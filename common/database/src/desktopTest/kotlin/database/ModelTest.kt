package database

import app.cash.sqldelight.driver.jdbc.sqlite.JdbcSqliteDriver
import app.cash.turbine.test
import com.mshabiola.database.TempDatabase
import com.mshabiola.database.dao.modeldao.ModelDao
import com.mshabiola.database.di.daoModules
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Rule
import org.junit.Test
import org.koin.core.component.inject
import org.koin.dsl.module
import org.koin.test.KoinTest
import org.koin.test.KoinTestRule
import kotlin.test.assertEquals

class ModelTest :KoinTest {

    @get:Rule
    val koinTestRule = KoinTestRule.create {
        val module= module {
            single {
                val driver = JdbcSqliteDriver(JdbcSqliteDriver.IN_MEMORY)
                    .also { TempDatabase.Schema.create(it) }

                TempDatabase(driver)
            }

        }
        // Your KoinApplication instance here
        modules(module, daoModules)

    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun test()= runTest{
        val modelDao by inject<ModelDao>()

        modelDao.getAllModel()
            .test {
                val list=awaitItem()
                print(list)
                assertEquals(1,list.size)
                this.cancelAndIgnoreRemainingEvents()
            }

    }



}