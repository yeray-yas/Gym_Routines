package com.yerayyas.gymroutines.core.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class WorkoutEntity(
    @PrimaryKey(autoGenerate = true)
    val workoutId: Long? = null,
    val name: String,
    val routineId: Long,
    val creationTime: Long
)
