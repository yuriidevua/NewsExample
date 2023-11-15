package com.arch.featurelocalstorage

import android.content.Context
import androidx.room.Room
import javax.inject.Inject

class LocaleStorage (context: Context) : Dao {
    private val dao: DataBase

    init {
        dao = Room.databaseBuilder(context.applicationContext,
            DataBase::class.java,
            BuildConfig.DAO_NAME)
            .build()
    }


    override fun daoEntry(): LocaleDaoEntry {
        return dao.daoEntry()
    }
}