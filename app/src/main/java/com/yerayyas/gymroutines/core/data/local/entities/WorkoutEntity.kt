package com.yerayyas.gymroutines.core.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class WorkoutEntity(
    @PrimaryKey(autoGenerate = false)
    val workoutId: String,
    val name: String,
    val routineId: String
)
