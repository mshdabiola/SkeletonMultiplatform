package com.mshabiola.database.dao.modeldao

import app.cash.sqldelight.Query
import app.cash.sqldelight.db.QueryResult
import app.cash.sqldelight.db.SqlCursor
import com.mshabiola.database.model.toModel
import com.mshdabiola.model.ImageModel
import com.mshdabiola.model.Model
import commshdabioladatabase.tables.ImageEntity
import commshdabioladatabase.tables.ModelEntity


fun Query<ImageEntity>.toModel(): Query<ImageModel> =
    object : Query<ImageModel>({ cursor -> mapper(cursor).toModel() }) {
        override fun <R> execute(mapper: (SqlCursor) -> QueryResult<R>) = this@toModel.execute(mapper)
        override fun addListener(listener: Listener) = this@toModel.addListener(listener)
        override fun removeListener(listener: Listener) = this@toModel.removeListener(listener)
    }



fun Query<ModelEntity>.toModel2(): Query<Model> =
    object : Query<Model>({ cursor -> mapper(cursor).toModel() }) {
        override fun <R> execute(mapper: (SqlCursor) -> QueryResult<R>) = this@toModel2.execute(mapper)
        override fun addListener(listener: Listener) = this@toModel2.addListener(listener)
        override fun removeListener(listener: Listener) = this@toModel2.removeListener(listener)
    }

