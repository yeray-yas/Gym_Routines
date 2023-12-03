package com.yerayyas.gymroutines.core.data.mapper

import com.yerayyas.gymroutines.core.data.local.entities.RoutineEntity
import com.yerayyas.gymroutines.core.domain.model.Routine

fun RoutineEntity.toDomain(): Routine {
    return Routine(
        id = this.routineId,
        name = this.name,
        workouts = emptyList()
    )
}

fun Routine.toEntity(): RoutineEntity {
    return RoutineEntity(
      routineId = this.id,
        name = this.name
    )
}