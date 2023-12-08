package com.yerayyas.gymroutines.core.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class RoutineEntity(
    @PrimaryKey(autoGenerate = true)
    val routineId: Long? = null,
    val name: String,
)
