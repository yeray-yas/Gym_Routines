package com.yerayyas.gymroutines.core.domain.model

data class Exercise(
    val id: String,
    val name: String, // BenchPress
    val sets: List<WorkoutSet>
)
