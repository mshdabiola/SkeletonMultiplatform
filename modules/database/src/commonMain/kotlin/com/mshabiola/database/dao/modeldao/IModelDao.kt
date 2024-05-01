package com.mshabiola.database.dao.modeldao

import androidx.paging.PagingSource
import com.mshdabiola.model.ImageModel
import com.mshdabiola.model.Model
import kotlinx.coroutines.flow.Flow

interface IModelDao {

    val pagingSource: PagingSource<Int, Model>

    suspend fun upsert(modelEntity: Model):Long

    fun getAllModel(): Flow<List<Model>>

    suspend fun updateModel(model: Model)
    fun getOneModel(id: Long): Flow<Model>
    suspend fun delete(id: Long)
}
