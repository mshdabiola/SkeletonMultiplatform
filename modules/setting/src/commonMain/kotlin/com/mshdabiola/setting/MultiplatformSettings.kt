package com.mshdabiola.setting

import com.mshdabiola.model.Contrast
import com.mshdabiola.model.DarkThemeConfig
import com.mshdabiola.model.DummySetting
import com.mshdabiola.model.ThemeBrand
import com.mshdabiola.model.UserData
import kotlinx.coroutines.flow.Flow

interface MultiplatformSettings {

    val name: Flow<String>
    val dummy: Flow<DummySetting>
    val userData :Flow<UserData>

    suspend fun setName(name: String)

    suspend fun setDummy(dummy: DummySetting)


    suspend fun setThemeBrand(themeBrand: ThemeBrand)

    suspend fun setThemeContrast(contrast: Contrast)

    suspend fun setDynamicColorPreference(useDynamicColor: Boolean)

    suspend fun setDarkThemeConfig(darkThemeConfig: DarkThemeConfig)


    suspend fun setShouldHideOnboarding(shouldHideOnboarding: Boolean)
}
