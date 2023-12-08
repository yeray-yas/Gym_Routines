package com.yerayyas.gymroutines.core.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ExerciseEntity(
    @PrimaryKey(autoGenerate = true)
    val exerciseId: Long? = null,
    val name: String,
    val workoutId: Long
)
