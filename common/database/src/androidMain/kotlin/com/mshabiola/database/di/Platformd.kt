package com.mshabiola.database.di

import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import com.mshabiola.database.TempDatabase
import com.mshabiola.database.util.Constant
import org.koin.core.module.Module
import org.koin.dsl.module

actual val databaseModule: Module
    get() = module {
        single {
            val driver =AndroidSqliteDriver(
                schema = TempDatabase.Schema,
                context = get (),
                name = Constant.databaseName
            )

            TempDatabase(driver)
        }
        includes(daoModules)
    }