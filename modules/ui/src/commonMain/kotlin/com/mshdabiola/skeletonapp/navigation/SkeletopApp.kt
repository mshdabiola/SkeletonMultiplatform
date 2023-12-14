package com.mshdabiola.skeletonapp.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.DefaultComponentContext
import com.mshdabiola.designsystem.theme.AppTheme
import com.mshdabiola.navigation.RootComponent


@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
@Composable
fun SkeletonApp(context: DefaultComponentContext, isDarkMode: Boolean) {

    val rootComp = remember {  RootComponent(context)}
    val windowSizeClass =   calculateWindowSizeClass()

    AppTheme(isDarkMode = isDarkMode) {
        SkeletonAppNavHost(
            iRootComponent = rootComp,
            modifier = Modifier.fillMaxSize(),
            windowSizeClass = windowSizeClass
        )
    }



}
