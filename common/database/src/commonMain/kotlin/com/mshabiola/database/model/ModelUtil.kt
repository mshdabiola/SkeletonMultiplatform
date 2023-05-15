package com.mshabiola.database.model

import com.mshdabiola.model.Model
import commshdabioladatabase.migrations.ModelEntity


fun ModelEntity.toModel()=Model(id, name)


fun Model.toEntity()=ModelEntity(id, name,9)