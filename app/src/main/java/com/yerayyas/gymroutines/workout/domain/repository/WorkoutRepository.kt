package com.yerayyas.gymroutines.workout.domain.repository

import com.yerayyas.gymroutines.core.domain.model.Workout

interface WorkoutRepository {
    suspend fun getAllWorkoutsByRoutine(routineId: String): List<Workout>
}