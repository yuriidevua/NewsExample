import org.jetbrains.kotlin.gradle.dsl.kotlinExtension

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-parcelize")
}

android {
    namespace = "com.arch.portdomain"
    compileSdk = Versions.targetSdk

    defaultConfig {
        minSdk = Versions.minSdk
        consumerProguardFiles("consumer-rules.pro")
    }
    buildTypes {
        getByName("debug") {
            isMinifyEnabled = false
            manifestPlaceholders["versionCode"] = Versions.versionCode
            manifestPlaceholders["appName"] = Versions.appName
                .plus("_")
                .plus(Versions.versionName)
                .plus("_debug")
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        getByName("release") {
            isMinifyEnabled = true
            manifestPlaceholders["versionCode"] = Versions.versionCode
            manifestPlaceholders["appName"] =  Versions.appName
                .plus("_")
                .plus(Versions.versionName)
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    java.toolchain {
        languageVersion.set(JavaLanguageVersion.of(Versions.varsionJava))
    }
    kotlinExtension.jvmToolchain {
        languageVersion.set(JavaLanguageVersion.of(Versions.varsionJava))
    }
}

dependencies {
    Depend.dagger.forEach { implementation(it) }
    //RX
    Depend.rxAndroid.forEach { implementation(it) }
}