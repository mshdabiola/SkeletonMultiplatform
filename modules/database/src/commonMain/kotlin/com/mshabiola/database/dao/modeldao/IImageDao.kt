package com.mshabiola.database.dao.modeldao

import androidx.paging.PagingSource
import com.mshdabiola.model.ImageModel

interface IImageDao {

    val pagingSource: PagingSource<Int, ImageModel>
    suspend fun insert(imageModel: ImageModel)

    suspend fun clear()

    fun all(limit:Int,offset:Int) :List<ImageModel>
 //   suspend fun count()
   // fun all(limit: Long, offset: Long): List<ImageInfo>
}
