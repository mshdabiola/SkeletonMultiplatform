/*
 *abiola 2024
 */

package com.mshdabiola.data.fake

import com.mshdabiola.data.repository.IModelRepository
import com.mshdabiola.model.Note
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class FakeNoteRepository : IModelRepository {

    private val data = mutableListOf<Note>()
    override suspend fun upsert(note: Note): Long {
        data.add(note)
        val lastIndex = data.lastIndex

        return note.id ?: lastIndex.toLong()
    }

    override fun getAll(): Flow<List<Note>> {
        return flow { data }
    }

    override fun getOne(id: Long): Flow<Note?> {
        return flow { data.find { it.id == id } }
    }

    override suspend fun delete(id: Long) {
        data.removeIf { it.id == id }
    }
}
