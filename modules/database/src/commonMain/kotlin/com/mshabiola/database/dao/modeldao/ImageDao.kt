package com.mshabiola.database.dao.modeldao

import androidx.paging.PagingSource
import app.cash.sqldelight.paging3.QueryPagingSource
import com.mshabiola.database.model.toEntity
import com.mshabiola.database.model.toModel
import com.mshdabiola.model.ImageModel
import commshdabioladatabase.tables.ImageQueries
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class ImageDao(
    private val imageQueries: ImageQueries,
    private val coroutineDispatcher: CoroutineDispatcher,
) : IImageDao {
    override val pagingSource: PagingSource<Int, ImageModel>
        get() = QueryPagingSource(
            countQuery = imageQueries.countPlayers(),
            transacter = imageQueries,
            context =coroutineDispatcher,
            queryProvider = {limit, offset ->
                  imageQueries.all(limit, offset).toModel()
            },
        )

    override suspend fun insert(imageModel: ImageModel) {
       withContext(coroutineDispatcher){
           imageQueries.insertFullModelObject (imageModel.toEntity())
       }
    }

    override suspend fun clear() {
        withContext(coroutineDispatcher){
            imageQueries.clear()
        }
    }

    override  fun all(limit: Int, offset: Int): List<ImageModel> {
       return imageQueries.all(limit.toLong(),offset.toLong())
           .executeAsList()
           .map {
               it.toModel()
           }
    }

//    override suspend fun count(): {
//
//    }


}
