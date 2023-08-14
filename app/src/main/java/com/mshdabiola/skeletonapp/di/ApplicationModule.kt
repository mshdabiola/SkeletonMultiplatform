package com.mshdabiola.skeletonapp.di


import com.mshdabiola.data.di.dataModule
import com.mshdabiola.skeletonapp.screen.detail.DetailViewModel
import com.mshdabiola.skeletonapp.screen.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val appModule= module {
    includes(dataModule)
    viewModelOf(::MainViewModel)
    viewModelOf(::DetailViewModel)
}