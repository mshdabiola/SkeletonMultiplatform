package com.mshdabiola.skeletonapp

import android.app.Application
import androidx.work.ExistingWorkPolicy
import androidx.work.WorkManager
import com.mshdabiola.skeletonapp.di.appModule
import com.mshdabiola.skeletonapp.worker.SaveWorker
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import timber.log.Timber


class SkeletonApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@SkeletonApplication)
            modules(appModule)
        }

        val workManager = WorkManager.getInstance(applicationContext)
        workManager
            .enqueueUniqueWork(
                "updater",
                ExistingWorkPolicy.REPLACE,
                SaveWorker.getRequest()
            )
        if (packageName.contains("debug")) {
            Timber.plant(Timber.DebugTree())
            Timber.e("log on app create")
        }
    }
}
