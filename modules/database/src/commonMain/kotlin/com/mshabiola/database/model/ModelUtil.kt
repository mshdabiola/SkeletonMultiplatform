package com.mshabiola.database.model

import com.mshdabiola.model.ImageModel
import com.mshdabiola.model.Model
import commshdabioladatabase.tables.ImageEntity
import commshdabioladatabase.tables.ModelEntity

fun ModelEntity.toModel() = Model(id, title,content?:"")

fun Model.toEntity() = ModelEntity(id?:0, title, content)

fun ImageModel.toEntity()= ImageEntity(
    id = id?:"",
    user = user?:"",
    userId = userid?.toLong() ?: 4,
    url = url?:"",
    timestamp = timestamp,
    mime = mime,
    mediatype = mediatype,
    descriptionUrl = descriptionurl,
    descriptionShortUr = descriptionshorturl
)

fun ImageEntity.toModel()=ImageModel(
    id = id?:"",
    user = user?:"",
    userid = userId?.toInt(),
    url = url?:"",
    timestamp = timestamp,
    mime = mime,
    mediatype = mediatype,
    descriptionurl = descriptionUrl,
    descriptionshorturl = descriptionShortUr
)

