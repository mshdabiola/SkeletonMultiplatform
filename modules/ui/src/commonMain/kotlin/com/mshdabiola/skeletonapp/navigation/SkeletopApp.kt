package com.mshdabiola.skeletonapp.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.DefaultComponentContext
import com.mshdabiola.designsystem.theme.AppTheme
import com.mshdabiola.navigation.RootComponent


@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
@Composable
fun SkeletonApp(context: DefaultComponentContext, isDarkMode: Boolean) {

    val rootComp = RootComponent(context)
//    val windowSizeClass =    WindowSizeClass.calculateFromSize(Size(451f,456f), LocalDensity.current)

    AppTheme(isDarkMode = isDarkMode) {
        SkeletonAppNavHost(
            iRootComponent = rootComp,
            modifier = Modifier.fillMaxSize(),
        )
    }



}
