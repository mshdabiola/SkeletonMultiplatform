package com.mshdabiola.skeletonapp.navigation

import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.Children
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.fade
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.plus
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.slide
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.stackAnimation
import com.mshdabiola.navigation.IRootComponent
import com.mshdabiola.skeletonapp.screen.detail.DetailScreenn
import com.mshdabiola.skeletonapp.screen.main.MainScreenNav


@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
@Composable
fun SkeletonAppNavHost(modifier: Modifier,iRootComponent: IRootComponent,windowSizeClass: WindowSizeClass) {

    Children(
        stack = iRootComponent.stack,
        modifier = modifier,
        animation = stackAnimation(fade() + slide())
    ) {

        when (it.instance) {
            is IRootComponent.RootScreen.MainRootScreen -> {
                MainScreenNav { iRootComponent.navigateToDetail() }
            }

            is IRootComponent.RootScreen.DetailRootScreen -> {
                DetailScreenn(windowSizeClass) {

                }
            }
        }

    }
}
