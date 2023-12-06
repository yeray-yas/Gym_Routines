package com.yerayyas.gymroutines.core.data.local.entities.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.yerayyas.gymroutines.core.data.local.entities.RoutineEntity
import com.yerayyas.gymroutines.core.data.local.entities.WorkoutEntity

data class RoutineWithWorkouts(
    @Embedded val routineEntity: RoutineEntity,
    @Relation(
        parentColumn = "routineId",
        entityColumn = "routineId",
        entity = WorkoutEntity::class
    )
    val workouts: List<WorkoutWithExercises>
)
