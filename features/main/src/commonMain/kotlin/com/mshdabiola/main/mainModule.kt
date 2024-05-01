package com.mshdabiola.main

import com.mshdabiola.data.di.dataModule
import com.mshdabiola.mvvn.commonViewModel
import org.koin.dsl.module

val mainModule = module {
    commonViewModel {
        MainViewModel(get(),get()) }
}
