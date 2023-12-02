package com.yerayyas.gymroutines.core.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class WorkoutSetEntity(
    @PrimaryKey(autoGenerate = true)
    val workoutSetId: Int? = null,
    val weight: Double,
    val repetitions: Int,
    val exerciseId: String
)
