package com.yerayyas.gymroutines.core.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class WorkoutSetEntity(
    @PrimaryKey(autoGenerate = true)
    val workoutSetId: Long? = null,
    val weight: Double,
    val repetitions: Int,
    val exerciseId: Long
    // TODO: Add min and max repetitions, for automatic progressive overload
)
