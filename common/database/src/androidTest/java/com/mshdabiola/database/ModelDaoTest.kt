package com.mshdabiola.database
//
//import android.content.Context
//import androidx.room.Room
//import androidx.test.core.app.ApplicationProvider
//import androidx.test.ext.junit.runners.AndroidJUnit4
//import com.mshdabiola.database.dao.IModelDao
//import kotlinx.coroutines.runBlocking
//import org.junit.After
//import org.junit.Before
//import org.junit.Test
//import org.junit.runner.RunWith
//
//@RunWith(AndroidJUnit4::class)
//class ModelDaoTest {
//    lateinit var IModelDao: IModelDao
//    private lateinit var db: SkeletonDatabase
//
//    @Before
//    fun before() {
//        val content = ApplicationProvider.getApplicationContext<Context>()
//        db = Room.inMemoryDatabaseBuilder(content, SkeletonDatabase::class.java).build()
//    }
//
//    @After
//    fun after() {
//        db.close()
//    }
//
//    @Test
//    fun upsertTest() = runBlocking {
//    }
//
//    @Test
//    fun deleteTest() = runBlocking {
//    }
//
//    @Test
//    fun deleteByIdTest() = runBlocking {
//    }
//}
