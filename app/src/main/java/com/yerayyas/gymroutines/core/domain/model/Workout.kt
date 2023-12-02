package com.yerayyas.gymroutines.core.domain.model

data class Workout(
    val id: String,
    val name: String, // Workout A, Workout B, etc
    val exercises: List<Exercise>
)
