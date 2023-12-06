package com.yerayyas.gymroutines.core.data.mapper

import com.yerayyas.gymroutines.core.data.local.entities.RoutineEntity
import com.yerayyas.gymroutines.core.data.local.entities.relations.RoutineWithWorkouts
import com.yerayyas.gymroutines.core.domain.model.Routine

fun RoutineEntity.toDomain(): Routine {
    return Routine(
        id = this.routineId,
        name = this.name,
        workouts = emptyList()
    )
}

fun RoutineWithWorkouts.toDomain(): Routine {
    return Routine(
        id = this.routineEntity.routineId,
        name = this.routineEntity.name,
        workouts = this.workouts.map { it.toDomain() }
    )
}

fun Routine.toEntity(): RoutineEntity {
    return RoutineEntity(
        routineId = this.id,
        name = this.name
    )
}