package com.yerayyas.gymroutines.core.data.local.entities.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.yerayyas.gymroutines.core.data.local.entities.WorkoutEntity
import com.yerayyas.gymroutines.core.data.local.entities.WorkoutLogEntity

data class WorkoutLogWithWorkout(
    @Embedded val workoutLogEntity: WorkoutLogEntity,
    @Relation(
        parentColumn = "workoutId",
        entityColumn = "workoutId",
        entity = WorkoutEntity::class
    )
    val workout: WorkoutWithExercises
)
