package com.yerayyas.gymroutines.core.domain.model

data class Workout(
    val id: Long?,
    val name: String, // Workout A, Workout B, etc
    val exercises: List<Exercise>
)
