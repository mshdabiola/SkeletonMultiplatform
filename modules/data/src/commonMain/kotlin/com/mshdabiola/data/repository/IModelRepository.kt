package com.mshdabiola.data.repository

import androidx.paging.PagingData
import com.mshdabiola.model.Image
import com.mshdabiola.model.Note
import kotlinx.coroutines.flow.Flow

interface IModelRepository {

    suspend fun upsert(note: Note): Long
    fun getAll(): Flow<List<Note>>

    fun getOne(id: Long): Flow<Note?>

    suspend fun delete(id: Long)

//    fun imagePagingData (): Flow<PagingData<Image>>

//    fun notePagingData (): Flow<PagingData<Note>>


}
