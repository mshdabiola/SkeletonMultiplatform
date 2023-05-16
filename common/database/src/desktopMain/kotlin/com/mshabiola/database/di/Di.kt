package com.mshabiola.database.di

import app.cash.sqldelight.driver.jdbc.sqlite.JdbcSqliteDriver
import com.mshabiola.database.util.Constant
import com.mshdabiola.database.TempDatabase
import org.koin.core.module.Module
import org.koin.dsl.module
import java.io.File

actual val databaseModule: Module
    get() = module {
        single {
            val dbPath = File(System.getProperty("java.io.tmpdir"), Constant.databaseName)
            val driver = JdbcSqliteDriver(url = "jdbc:sqlite:${dbPath.absolutePath}")
                .also { TempDatabase.Schema.create(it) }
            println("version ${TempDatabase.Schema.version}")

            TempDatabase(driver)
        }

        includes(daoModules)

    }