package com.yerayyas.gymroutines.core.domain.model

data class Routine(
    val id: String,
    val name: String, // 3x for week, 5x for week
    val workouts: List<Workout>
)
