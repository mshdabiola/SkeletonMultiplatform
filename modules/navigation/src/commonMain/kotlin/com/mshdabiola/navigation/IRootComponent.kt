package com.mshdabiola.navigation

import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value

interface IRootComponent {
    val stack: Value<ChildStack<*, RootScreen>>

    fun navigateToDetail()

    fun navigateToSetting()
    fun back()

    sealed class RootScreen {
        class MainRootScreen(val component: MainComponent) : RootScreen()
        class DetailRootScreen(val component: DetailComponent) : RootScreen()

        class SettingRootScreen(val component: SettingComponent) : RootScreen()
    }
}
