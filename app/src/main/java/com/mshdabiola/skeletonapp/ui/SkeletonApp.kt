package com.mshdabiola.skeletonapp.ui

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.mshdabiola.designsystem.theme.AppTheme
import com.mshdabiola.navigation.IRootComponent
import com.mshdabiola.skeletonapp.navigation.SkeletonAppNavHost


@Composable
fun SkeletonApp2(
    iRootComponent: IRootComponent
) {
    AppTheme (isDarkMode = isSystemInDarkTheme()){
        SkeletonAppNavHost(iRootComponent = iRootComponent, modifier = Modifier.fillMaxSize())
    }
}
