package com.arch.portdata

import com.arch.portdata.model.DataNews
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

interface IRepositoryDAO {
    fun saveFavorites(data: DataNews): Completable

    fun getFavorites(): Single<List<DataNews>>

    fun deleteFavorites(data : DataNews) : Single<Int>

    fun deleteFavoritesTable() : Completable

}