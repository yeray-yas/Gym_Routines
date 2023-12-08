package com.yerayyas.gymroutines.core.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class WorkoutLogEntity(
    @PrimaryKey(autoGenerate = true)
    val workoutLogId: Long? = null,
    val bodyWeight: Double,
    val date: Long,
    val workoutId: Long,
    val routineId: Long
)
