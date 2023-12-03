package com.yerayyas.gymroutines.workout.domain.repository

import com.yerayyas.gymroutines.core.domain.model.Workout

interface WorkoutRepository {
    suspend fun getAllWorkoutsIdsByRoutine(routineId: String): List<String>

    suspend fun getWorkoutById(id: String): Workout
}