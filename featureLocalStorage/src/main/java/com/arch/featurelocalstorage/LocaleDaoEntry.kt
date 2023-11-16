package com.arch.featurelocalstorage

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.arch.featurelocalstorage.entry.Entry
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

@Dao
interface LocaleDaoEntry {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertListEntry(list: List<Entry>) : Completable

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertEntry(entry: Entry) : Completable

    @Query("select * from entry")
    fun queryEntryList(): Single<List<Entry>>

    @Query("SELECT * FROM entry WHERE id IS :id")
    fun queryEntry(id: String): Single<Entry>

    @Query("DELETE FROM entry")
    fun deleteTable() : Completable

    @Query("DELETE FROM entry WHERE id = :id")
    fun deleteEntry(id: Long) : Single<Int>

    @Delete
    fun deleteEntry(entry: Entry) : Int
}