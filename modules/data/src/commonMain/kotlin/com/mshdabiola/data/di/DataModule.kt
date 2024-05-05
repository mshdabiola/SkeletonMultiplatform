package com.mshdabiola.data.di

import com.mshdabiola.analytics.di.analyticsModule
import com.mshdabiola.data.repository.IModelRepository
import com.mshdabiola.data.repository.INetworkRepository
import com.mshdabiola.data.repository.OfflineFirstUserDataRepository
import com.mshdabiola.data.repository.RealINetworkRepository
import com.mshdabiola.data.repository.RealModelRepository
import com.mshdabiola.data.repository.UserDataRepository
import com.mshdabiola.database.di.databaseModule
import com.mshdabiola.network.di.networkModule
import com.mshdabiola.setting.di.settingModule
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val dataModule = module {
    includes(settingModule, databaseModule, networkModule, analyticsModule)
    single { Dispatchers.IO } bind CoroutineDispatcher::class
    singleOf(::RealINetworkRepository) bind INetworkRepository::class
    singleOf(::RealModelRepository) bind IModelRepository::class
    singleOf(::OfflineFirstUserDataRepository) bind UserDataRepository::class
}
