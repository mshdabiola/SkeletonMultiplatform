package com.mshdabiola.setting

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import com.mshdabiola.setting.model.Dummy
import okio.Path.Companion.toPath

object Keys {
    const val setting = "dummy"


    object Defaults {
        val defaultDummy = Dummy("abiola", "male")
    }
}


internal const val dataStoreFileName = "meetings.preferences_pb"


fun createDataStore(
    producePath: () -> String,
): DataStore<Preferences> = PreferenceDataStoreFactory.createWithPath(
    corruptionHandler = null,
    migrations = emptyList(),
    produceFile = { producePath().toPath() },
)
