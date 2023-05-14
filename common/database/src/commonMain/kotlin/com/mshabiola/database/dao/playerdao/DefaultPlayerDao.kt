package com.mshabiola.database.dao.playerdao

import app.cash.sqldelight.coroutines.asFlow
import app.cash.sqldelight.coroutines.mapToList
import commshdabioladatabase.tables.HockeyPlayer
import commshdabioladatabase.tables.PlayerQueries
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow

class DefaultPlayerDao(private val coroutineDispatcher: CoroutineDispatcher, private val player: PlayerQueries) : PlayerDao {
    override fun getAllPlayer(): Flow<List<HockeyPlayer>> {
        return player.selectAll()
            .asFlow()
            .mapToList(coroutineDispatcher)
    }


}