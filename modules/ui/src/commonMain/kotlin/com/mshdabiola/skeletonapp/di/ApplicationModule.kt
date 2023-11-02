package com.mshdabiola.skeletonapp.di


import com.mshdabiola.data.di.dataModule
import com.mshdabiola.mvvn.commonViewModel
import com.mshdabiola.skeletonapp.screen.detail.DetailViewModel
import com.mshdabiola.skeletonapp.screen.main.MainViewModel
import org.koin.dsl.module


val appModule = module {
    includes(dataModule)
    commonViewModel { DetailViewModel() }
    commonViewModel { MainViewModel(get()) }
}