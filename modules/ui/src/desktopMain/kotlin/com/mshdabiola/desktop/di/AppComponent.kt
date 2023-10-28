package com.mshdabiola.desktop.di

import com.mshdabiola.data.di.dataModule
import com.mshdabiola.desktop.ui.feature.main.MainViewModel
import com.mshdabiola.desktop.ui.feature.splash.SplashViewModel
import com.mshdabiola.ui.commonModule
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

object Modules{


}
val desktopModule = module{

    includes(commonModule)
    factoryOf(::SplashViewModel);
    factoryOf(::MainViewModel)


    includes(dataModule)
    //singleOf(::MainScreenComponent)
}