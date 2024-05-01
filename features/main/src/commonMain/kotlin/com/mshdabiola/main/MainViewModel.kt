/*
 *abiola 2022
 */

package com.mshdabiola.main

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import androidx.paging.map
import com.mshdabiola.data.repository.IModelRepository
import com.mshdabiola.mvvn.ViewModel
import com.mshdabiola.data.repository.UserDataRepository
import com.mshdabiola.model.Model
import com.mshdabiola.ui.MainState
import com.mshdabiola.ui.asModelUiState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import kotlin.random.Random

class MainViewModel constructor(
    private val userDataRepository: UserDataRepository,
    private val modelRepository: IModelRepository,

    ) : ViewModel() {

    val timeLine = Pager(PagingConfig(20)){
        modelRepository.getModePagingSource()
    }
        .flow
        .map { it.map { it.asModelUiState() } }
        .cachedIn(viewModelScope)
    @OptIn(ExperimentalPagingApi::class)

    val pager = Pager(
        PagingConfig(4),
        remoteMediator = modelRepository.getTimelineMediator()
    ){
        modelRepository.getTimeSource()
    }
        .flow
        .cachedIn(viewModelScope)

    private val _mainState = MutableStateFlow(MainState())
    val mainState = _mainState.asStateFlow()

    init {
        viewModelScope.launch {
            delay(2000)
            addNotify("Add Model")
            addNotify("remove model")
        }
    }

    fun addName(name: String) {
        insert(Model(title = name, id = Random(34).nextLong()))
    }

    fun insert(model: Model) {
        viewModelScope.launch(Dispatchers.IO) {
            modelRepository.upsert(model)
        }
    }

    private fun addNotify(text: String) {
//        val notifies = mainState.value.messages.toMutableList()
//
//        notifies.add(Notify(message = text, callback = ::onNotifyDelive))
//        _mainState.update {
//            it.copy(messages = notifies.toImmutableList())
        // }
    }

    private fun onNotifyDelive() {
//        val notifies = mainState.value.messages.toMutableList()
//
//        notifies.removeFirst()
//        _mainState.value = mainState.value.copy(messages = notifies.toImmutableList())
    }
}
