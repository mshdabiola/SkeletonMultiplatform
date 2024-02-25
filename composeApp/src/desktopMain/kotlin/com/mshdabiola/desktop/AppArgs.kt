package com.mshdabiola.desktop

import com.mshdabiola.analytics.AnalyticsHelper
import com.mshdabiola.skeletonapp.MainAppViewModel
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

data class AppArgs(
    val appName: String,
    val version: String,
    val versionCode: Int,
)