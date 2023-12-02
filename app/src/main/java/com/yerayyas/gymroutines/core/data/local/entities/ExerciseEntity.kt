package com.yerayyas.gymroutines.core.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ExerciseEntity(
    @PrimaryKey(autoGenerate = false)
    val exerciseId: String,
    val name: String,
    val workoutId: String
)
