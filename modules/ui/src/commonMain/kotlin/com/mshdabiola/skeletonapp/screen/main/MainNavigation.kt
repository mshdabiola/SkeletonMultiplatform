package com.mshdabiola.skeletonapp.screen.main

import androidx.compose.runtime.Composable

@Composable
fun MainScreenNav(onBack: () -> Unit) {
    MainScreen {
        onBack()
    }
}

