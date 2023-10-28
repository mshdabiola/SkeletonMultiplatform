package com.mshdabiola.skeletonapp.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.DefaultComponentContext
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.Children
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.fade
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.plus
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.slide
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.stackAnimation
import com.mshdabiola.designsystem.theme.AppTheme
import com.mshdabiola.navigation.IRootComponent
import com.mshdabiola.navigation.RootComponent
import com.mshdabiola.skeletonapp.screen.detail.DetailScreenn
import com.mshdabiola.skeletonapp.screen.main.MainScreenNav


@Composable
fun SkeletonAppNavHost(iRootComponent: IRootComponent, modifier: Modifier) {

    Children(
        stack = iRootComponent.stack,
        modifier=modifier,
        animation = stackAnimation(fade()+ slide())
        ){

        when(it.instance){
            is IRootComponent.RootScreen.MainRootScreen->{
                MainScreenNav { iRootComponent.navigateToDetail() }
            }
            is IRootComponent.RootScreen.DetailRootScreen->{
                DetailScreenn {

                }
            }
        }

    }
}

@Composable
fun SkeletonApp(context : DefaultComponentContext, isDarkMode:Boolean) {
    val rootComp = RootComponent(context)
    AppTheme (isDarkMode = isDarkMode){
        SkeletonAppNavHost(iRootComponent = rootComp, modifier = Modifier.fillMaxSize())
    }


}
