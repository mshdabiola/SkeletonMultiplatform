package com.mshabiola.database.dao.modeldao

import androidx.paging.PagingSource
import app.cash.sqldelight.coroutines.asFlow
import app.cash.sqldelight.coroutines.mapToList
import app.cash.sqldelight.coroutines.mapToOne
import app.cash.sqldelight.paging3.QueryPagingSource
import com.mshabiola.database.model.toEntity
import com.mshabiola.database.model.toModel
import com.mshdabiola.model.ImageModel
import com.mshdabiola.model.Model
import commshdabioladatabase.tables.ModelQueries
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext

class ModelDao(
    private val modelQueries: ModelQueries,
    private val coroutineDispatcher: CoroutineDispatcher,
) : IModelDao {

    override val pagingSource: PagingSource<Int, Model>
        get() = QueryPagingSource(
            countQuery = modelQueries.countModel(),
            transacter = modelQueries,
            context =coroutineDispatcher,
            queryProvider = {limit, offset ->
                modelQueries.all(limit, offset).toModel2()
            },
        )
    override suspend fun upsert(modelEntity: Model):Long {
     return   withContext(coroutineDispatcher) {
         return@withContext if (modelEntity.id==null){
             modelQueries.insertNew(modelEntity.toEntity())
             modelQueries.countModel().executeAsOne()

         }else{
             updateModel(modelEntity)
             modelEntity.id ?: 1

         }

        }
    }

    override fun getAllModel(): Flow<List<Model>> {
        return modelQueries.selectAllModel()
            .asFlow()
            .mapToList(coroutineDispatcher)
            .map { it.map { it.toModel() } }
    }

    override suspend fun updateModel(model: Model) {
        withContext(coroutineDispatcher) {
            modelQueries.updateByName(model.title,model.content,model.id?:0)
        }
    }

    override fun getOneModel(id: Long): Flow<Model> {
        return modelQueries.selectWIthId(id)
            .asFlow()
            .mapToOne(coroutineDispatcher)
            .map { it.toModel() }
    }

    override suspend fun delete(id: Long) {
        withContext(coroutineDispatcher) {
            modelQueries.deleteById(id)
        }
    }


}
