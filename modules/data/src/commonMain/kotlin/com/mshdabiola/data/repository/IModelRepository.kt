package com.mshdabiola.data.repository

import androidx.paging.PagingSource
import com.mshdabiola.data.ModeRemoteMediator
import com.mshdabiola.data.ModelPagingSource
import com.mshdabiola.model.ImageModel
import com.mshdabiola.model.Model
import kotlinx.coroutines.flow.Flow

interface IModelRepository {

    suspend fun upsert(model: Model):Long

    fun getAllModel(): Flow<List<Model>>

    suspend fun updateModel(model: Model)
    fun getOneModel(id: Long): Flow<Model>
    suspend fun delete(id: Long)

    fun getTimeline():ModelPagingSource
    fun getTimelineMediator():ModeRemoteMediator
    fun getTimeSource (): PagingSource<Int, ImageModel>

    fun getModePagingSource (): PagingSource<Int, Model>


}
