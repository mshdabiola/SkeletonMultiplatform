package com.mshdabiola.data.repository

import androidx.paging.PagingSource
import com.mshabiola.database.dao.modeldao.IImageDao
import com.mshabiola.database.dao.modeldao.IModelDao
import com.mshdabiola.data.ModeRemoteMediator
import com.mshdabiola.data.ModelPagingSource
import com.mshdabiola.model.ImageModel
import com.mshdabiola.model.Model
import com.mshdabiola.network.INetworkDataSource
import kotlinx.coroutines.flow.Flow

internal class RealModelRepository constructor(
    private val modelDao: IModelDao,
    private val iNetworkDataSource: INetworkDataSource,
    private val imageDao: IImageDao
) : IModelRepository {

    override suspend fun upsert(model: Model): Long {
      return  modelDao.upsert(model)
    }

    override fun getAllModel(): Flow<List<Model>> {
        return  modelDao.getAllModel()
    }

    override suspend fun updateModel(model: Model) {
        modelDao.updateModel(model)
    }

    override fun getOneModel(id: Long): Flow<Model> {
        return modelDao.getOneModel(id)
    }

    override suspend fun delete(id: Long) {
        modelDao.delete(id)
    }

    override fun getTimeline(): ModelPagingSource {
       return ModelPagingSource(iNetworkDataSource)
    }

    override fun getTimelineMediator(): ModeRemoteMediator {
        return ModeRemoteMediator(iNetworkDataSource,imageDao)
    }

    override fun getTimeSource(): PagingSource<Int, ImageModel> {
        return imageDao.pagingSource
    }

    override fun getModePagingSource(): PagingSource<Int, Model> {
        return modelDao.pagingSource
    }
}
