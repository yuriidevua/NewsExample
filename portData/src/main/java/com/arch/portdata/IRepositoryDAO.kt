package com.arch.portdata

import com.arch.portdata.model.DataNews
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

interface IRepositoryDAO {
    fun saveFavorites(item: DataNews): Completable

    fun getFavorites(): Single<List<DataNews>>

    fun deleteFavorites(data : DataNews) : Completable

    fun deleteFavoritesTable() : Completable

}