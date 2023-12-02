package com.yerayyas.gymroutines.core.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class RoutineEntity(
    @PrimaryKey(autoGenerate = false)
    val routineId: String,
    val name: String,
)
