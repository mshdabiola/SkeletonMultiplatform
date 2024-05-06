package com.mshdabiola.setting.di

import com.mshdabiola.model.generalPath
import com.mshdabiola.setting.createDataStoreUserData
import org.koin.core.module.Module
import org.koin.dsl.module

actual val settingModule: Module
    get() = module {
        includes(commonModule)
        single {
            createDataStoreUserData { "$generalPath/userdata" }
        }
    }
