package com.yerayyas.gymroutines.home.data.mappers

import com.yerayyas.gymroutines.core.data.local.entities.RoutineEntity
import com.yerayyas.gymroutines.core.domain.model.Routine

fun RoutineEntity.toDomain(): Routine {
    return Routine(
        id = this.routineId,
        name = this.name,
        workouts = emptyList()
    )
}