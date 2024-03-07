package com.mshdabiola.setting

import com.mshdabiola.model.Contrast
import com.mshdabiola.model.DarkThemeConfig
import com.mshdabiola.model.DummySetting
import com.mshdabiola.model.ThemeBrand
import com.mshdabiola.model.UserData
import com.mshdabiola.setting.model.Dummy
import com.mshdabiola.setting.model.UserDataSer
import com.mshdabiola.setting.model.toData
import com.mshdabiola.setting.model.toDummy
import com.mshdabiola.setting.model.toDummySetting
import com.mshdabiola.setting.model.toSer
import com.russhwolf.settings.ExperimentalSettingsApi
import com.russhwolf.settings.coroutines.FlowSettings
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

@OptIn(ExperimentalSettingsApi::class)
internal class MultiplatformSettingsImpl(
    private val settings: FlowSettings,
    private val coroutineDispatcher: CoroutineDispatcher,
) : MultiplatformSettings {
    private val nameKey="name"
    private val dummyKey="dummy"
    private val userKey="userKey"


    override val name: Flow<String> = settings.getStringOrNullFlow(nameKey).map { it ?: "nothing" }
    override val userData: Flow<UserData>
        get() = settings.getStringOrNullFlow(userKey) .map {

            if (it != null) {
                Json.decodeFromString<UserDataSer>(it).toData()
            } else {
                UserData(
                    themeBrand = ThemeBrand.DEFAULT,
                    darkThemeConfig = DarkThemeConfig.LIGHT,
                    useDynamicColor = false,
                    shouldHideOnboarding = false,
                    contrast = Contrast.Normal,
                )
            }
        }

    // .getStringFlow("NAME","Jamiu")
    override val dummy: Flow<DummySetting>
        get() = settings.getStringOrNullFlow(dummyKey).map {
            val jjj = it
            if (jjj != null) {
                Json.decodeFromString<Dummy>(jjj).toDummySetting()
            } else {
                Keys.Defaults.defaultDummy.toDummySetting()
            }
        }

    // MutableStateFlow(Keys.Defaults.defaultDummy.toDummySetting())

    override suspend fun setName(name: String) {
        settings.putString(nameKey,name)
    }

    override suspend fun setDummy(dummy: DummySetting) {
// Store values for the properties of someClass in settings
        val jjj = Json.encodeToString(dummy.toDummy())

        settings.putString(dummyKey,jjj)
    }

    override suspend fun setThemeBrand(themeBrand: ThemeBrand) {
        val userData = userData.first().copy(themeBrand = themeBrand)
        val userDataStr = Json.encodeToString(userData.toSer())
        settings.putString(userKey,userDataStr)
    }

    override suspend fun setThemeContrast(contrast: Contrast) {
        val userData = userData.first().copy(contrast = contrast)
        val userDataStr = Json.encodeToString(userData.toSer())
        settings.putString(userKey,userDataStr)
    }

    override suspend fun setDynamicColorPreference(useDynamicColor: Boolean) {
        val userData = userData.first().copy(useDynamicColor = useDynamicColor)
        val userDataStr = Json.encodeToString(userData.toSer())
        settings.putString(userKey,userDataStr)
    }

    override suspend fun setDarkThemeConfig(darkThemeConfig: DarkThemeConfig) {
        val userData = userData.first().copy(darkThemeConfig = darkThemeConfig)
        val userDataStr = Json.encodeToString(userData.toSer())
        settings.putString(userKey,userDataStr)
    }

    override suspend fun setShouldHideOnboarding(shouldHideOnboarding: Boolean) {
        val userData = userData.first().copy(shouldHideOnboarding = shouldHideOnboarding)
        val userDataStr = Json.encodeToString(userData.toSer())
        settings.putString(userKey,userDataStr)
    }
}
