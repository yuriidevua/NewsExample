package com.arch.featurelocalstorage

import androidx.room.Database
import androidx.room.RoomDatabase
import com.arch.featurelocalstorage.entry.Entry

@Database(entities = [Entry::class], version = 1, exportSchema = false)
abstract class DataBase : RoomDatabase() {
    abstract fun daoEntry(): LocaleDaoEntry
}