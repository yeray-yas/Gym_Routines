package com.yerayyas.gymroutines.core.data.local.entities.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.yerayyas.gymroutines.core.data.local.entities.ExerciseEntity
import com.yerayyas.gymroutines.core.data.local.entities.WorkoutSetEntity

data class ExerciseWithSets(
    @Embedded val exercise: ExerciseEntity,
    @Relation(
        parentColumn = "exerciseId",
        entityColumn = "exerciseId"
    )
    val sets: List<WorkoutSetEntity>
)
