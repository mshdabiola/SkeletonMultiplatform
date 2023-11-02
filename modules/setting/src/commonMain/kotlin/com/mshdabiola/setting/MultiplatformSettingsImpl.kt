package com.mshdabiola.setting

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import com.mshdabiola.model.DummySetting
import com.mshdabiola.setting.model.Dummy
import com.mshdabiola.setting.model.toDummy
import com.mshdabiola.setting.model.toDummySetting
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

internal class MultiplatformSettingsImpl(
    private val settings: DataStore<Preferences>,
    private val coroutineDispatcher: CoroutineDispatcher
) : MultiplatformSettings {

    val nameKey = stringPreferencesKey("Namme")
    val dummyKey = stringPreferencesKey("Dummy")

    override val name: Flow<String> = settings.data.map { it[nameKey] ?: "nothing" }

    //.getStringFlow("NAME","Jamiu")
    override val dummy: Flow<DummySetting>
        get() = settings.data.map {
            val jjj = it[nameKey]
            if (jjj != null) {
                Json.decodeFromString<Dummy>(jjj).toDummySetting()
            } else
                Keys.Defaults.defaultDummy.toDummySetting()
        }
    // MutableStateFlow(Keys.Defaults.defaultDummy.toDummySetting())

    override suspend fun setName(name: String) {
        settings.edit { it[nameKey] = name }//("NAME",name)
    }

    override suspend fun setDummy(dummy: DummySetting) {
// Store values for the properties of someClass in settings
        val jjj = Json.encodeToString(dummy.toDummy())

        settings.edit { it[dummyKey] = jjj }
    }

}
