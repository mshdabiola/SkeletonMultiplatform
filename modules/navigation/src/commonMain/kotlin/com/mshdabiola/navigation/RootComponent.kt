package com.mshdabiola.navigation

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.router.stack.pop
import com.arkivanov.decompose.router.stack.push
import com.arkivanov.decompose.value.Value
import kotlinx.serialization.Serializable

class RootComponent(
    componentContext: ComponentContext,
) : IRootComponent, ComponentContext by componentContext {
    private val navigation = StackNavigation<Config>()

    override val stack: Value<ChildStack<*, IRootComponent.RootScreen>>
        get() = _stack

    override fun navigateToDetail() {
        navigation.push(Config.Detail)
    }

    override fun navigateToSetting() {
        navigation.push(Config.Setting)
    }

    override fun back() {
        navigation.pop()
    }

    private val _stack = childStack(
        source = navigation,
        initialConfiguration = Config.Main,
        serializer = Config.serializer(),
        handleBackButton = true,
        childFactory = ::factory,
    )

    @Serializable
    private sealed interface Config {

        @Serializable
        data object Main : Config

        @Serializable
        data object Detail : Config

        @Serializable
        data object Setting : Config
    }

    private fun factory(
        config: Config,
        componentContext: ComponentContext,
    ): IRootComponent.RootScreen {
        return when (config) {
            is Config.Main -> IRootComponent.RootScreen.MainRootScreen(
                navigateToMain(
                    componentContext,
                ),
            )

            is Config.Detail -> IRootComponent.RootScreen.DetailRootScreen(
                navigateToDetail(
                    componentContext,
                ),
            )

            is Config.Setting -> IRootComponent.RootScreen.SettingRootScreen(
                navigateToSetting(
                    componentContext,
                ),
            )
        }
    }

    private fun navigateToMain(componentContext: ComponentContext): MainComponent {
        return MainComponent(componentContext)
    }

    private fun navigateToDetail(componentContext: ComponentContext): DetailComponent {
        return DetailComponent(
            componentContext,
            //  onSplashFinished = {navigation.replaceCurrent(Config.Main)}
        )
    }

    private fun navigateToSetting(componentContext: ComponentContext): SettingComponent {
        return SettingComponent(
            componentContext,
            //  onSplashFinished = {navigation.replaceCurrent(Config.Main)}
        )
    }
}
