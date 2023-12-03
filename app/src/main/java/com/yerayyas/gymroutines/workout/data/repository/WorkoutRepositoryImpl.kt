package com.yerayyas.gymroutines.workout.data.repository

import com.yerayyas.gymroutines.core.data.local.ExerciseDao
import com.yerayyas.gymroutines.core.data.local.RoutineDao
import com.yerayyas.gymroutines.core.data.local.WorkoutDao
import com.yerayyas.gymroutines.core.data.local.WorkoutSetDao
import com.yerayyas.gymroutines.core.domain.model.Workout
import com.yerayyas.gymroutines.core.data.mapper.toDomain
import com.yerayyas.gymroutines.workout.domain.repository.WorkoutRepository

class WorkoutRepositoryImpl(
    private val routineDao: RoutineDao,
    private val workoutDao: WorkoutDao,
    private val exerciseDao: ExerciseDao,
    private val workoutSetDao: WorkoutSetDao
) : WorkoutRepository {

    override suspend fun getAllWorkoutsIdsByRoutine(id: String): List<String> {
        return   workoutDao.getWorkoutsByRoutineId(id)
    }

    override suspend fun getWorkoutById(id: String): Workout {
        return workoutDao.getWorkoutById(id).toDomain(listOf()) // TODO: Poner los ejercicios aquí en los parámetros del toDomain()
    }
}