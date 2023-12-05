package com.yerayyas.gymroutines.core.domain.model

data class Exercise(
    val id: Long? = null,
    val name: String, // BenchPress
    val sets: List<WorkoutSet>
)
