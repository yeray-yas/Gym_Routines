package com.yerayyas.gymroutines.workout.domain.repository

import com.yerayyas.gymroutines.core.domain.model.Workout
import com.yerayyas.gymroutines.core.domain.model.WorkoutLog

interface WorkoutRepository {
    suspend fun getAllWorkoutsIdsByRoutine(routineId: Long): List<Long>

    suspend fun getWorkoutById(id: Long): Workout

    suspend fun getLastWorkoutLogInRoutine(routineId: Long): Long?

    suspend fun countAllWorkoutLogs(routineId: Long): Int

    suspend fun getLastWorkoutLogWorkout(workoutId: Long): Workout?

    suspend fun saveWorkout(routineId: Long, workoutLog: WorkoutLog)
}