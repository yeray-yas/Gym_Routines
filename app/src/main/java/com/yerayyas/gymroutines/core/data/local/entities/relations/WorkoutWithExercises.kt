package com.yerayyas.gymroutines.core.data.local.entities.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.yerayyas.gymroutines.core.data.local.entities.ExerciseEntity
import com.yerayyas.gymroutines.core.data.local.entities.WorkoutEntity

data class WorkoutWithExercises(
    @Embedded val workoutEntity: WorkoutEntity,
    @Relation(
        parentColumn = "workoutId",
        entityColumn = "workoutId",
        entity = ExerciseEntity::class
    )
    val exercises: List<ExerciseWithSets>
)
