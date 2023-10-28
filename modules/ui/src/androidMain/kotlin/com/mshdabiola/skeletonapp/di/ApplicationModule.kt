package com.mshdabiola.skeletonapp.di


import com.mshdabiola.data.di.dataModule
import com.mshdabiola.skeletonapp.screen.detail.DetailViewModel
import com.mshdabiola.skeletonapp.screen.main.MainViewModel
import com.mshdabiola.ui.commonModule
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val appModule= module {
    includes(commonModule)
    includes(dataModule)
    viewModelOf(::MainViewModel)
    viewModelOf(::DetailViewModel)
}