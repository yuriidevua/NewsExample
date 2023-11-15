package com.arch.data

import android.content.Context
import com.arch.featurelocalstorage.Dao
import com.arch.featurelocalstorage.LocaleStorage
import com.arch.portdata.IRepositoryDAO
import com.arch.portdata.model.DataNews
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single
import timber.log.Timber
import javax.inject.Inject

class RepositoryDAO @Inject constructor(context : Context) :BaseDAO(),IRepositoryDAO {
    private val storage : Dao

    init {
        storage = LocaleStorage(context)
    }

    override fun saveFavorites(item: DataNews): Completable  =
        mapperToEntry(item)
            .flatMapCompletable {storage.daoEntry().insertEntry(it)}
            .doOnError{Timber.tag(RepositoryDAO::class.simpleName).e(it)}

    override fun getFavorites(): Single<List<DataNews>> =
        storage.daoEntry().queryEntryList()
            .flatMap{mapperToData(it)}
            .doOnError{Timber.tag(RepositoryDAO::class.simpleName).e(it)}

    override fun deleteFavorites(data: DataNews): Completable  =
        mapperToEntry(data)
            .flatMapCompletable {storage.daoEntry().deleteEntry(it)}
            .doOnError{Timber.tag(RepositoryDAO::class.simpleName).e(it)}

    override fun deleteFavoritesTable(): Completable = storage.daoEntry().deleteTable()
        .doOnError{Timber.tag(RepositoryDAO::class.simpleName).e(it)}


}