package com.mshabiola.database.dao.playerdao

import com.mshabiola.database.TempDatabase
import commshdabioladatabase.tables.HockeyPlayer
import kotlinx.coroutines.flow.Flow

interface PlayerDao{

  fun getAllPlayer():Flow<List<HockeyPlayer>>
 }