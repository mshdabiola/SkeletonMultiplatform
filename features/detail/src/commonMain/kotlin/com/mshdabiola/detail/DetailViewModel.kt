/*
 *abiola 2022
 */

package com.mshdabiola.detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.snapshotFlow
import com.mshdabiola.data.repository.IModelRepository
import com.mshdabiola.model.Model
import kotlinx.coroutines.Job
import com.mshdabiola.mvvn.ViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import kotlin.random.Random


class DetailViewModel  constructor(
    //savedStateHandle: SavedStateHandle,
    id:Long,
    private val modelRepository: IModelRepository,
    ) : ViewModel() {
//    private val topicArgs: DetailArgs = DetailArgs(savedStateHandle)
//
//    private val topicId = topicArgs.id

    private var _noteState = mutableStateOf(Model())
    val noteState: State<Model> = _noteState

    init {
        viewModelScope.launch {
            println("id is $id")
            if (id > 0) {
                val note = modelRepository.getOneModel(id)
                    .first()
                _noteState.value = note
            }
        }

        viewModelScope.launch {
            snapshotFlow { noteState.value }
                .collectLatest {
                  val newId=  modelRepository.updateModel(it)

                    if (it.id == null) {


                    }
                }
        }
    }

    var job: Job? = null
    fun onTitleChange(text: String) {
        _noteState.value = noteState.value.copy(title = text)

    }

    fun onContentChange(text: String) {
        _noteState.value = noteState.value.copy(content = text)
    }

    fun onDelete() {
        viewModelScope.launch {
            noteState.value.id?.let { modelRepository.delete(it) }
        }
    }

    private  fun getId(): Long {
        val id=Random.nextLong()
        return id
    }

}
