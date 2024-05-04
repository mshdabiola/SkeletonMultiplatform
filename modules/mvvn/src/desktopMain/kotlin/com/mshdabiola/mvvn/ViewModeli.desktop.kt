package com.mshdabiola.mvvn

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.swing.Swing
import kotlin.coroutines.EmptyCoroutineContext

actual open class ViewModel actual constructor(){

    val dispacter=Dispatchers.Swing

    actual val viewModelScope: CoroutineScope
        get() = CoroutineScope(SupervisorJob() + dispacter)

    protected actual open fun onCleared() {
        viewModelScope.coroutineContext.cancel()
        viewModelScope.cancel()
    }
} //: ViewModel()
