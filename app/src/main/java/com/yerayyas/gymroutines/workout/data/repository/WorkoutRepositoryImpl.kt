package com.yerayyas.gymroutines.workout.data.repository

import com.yerayyas.gymroutines.core.data.local.ExerciseDao
import com.yerayyas.gymroutines.core.data.local.RoutineDao
import com.yerayyas.gymroutines.core.data.local.WorkoutDao
import com.yerayyas.gymroutines.core.data.local.WorkoutLogDao
import com.yerayyas.gymroutines.core.data.local.WorkoutSetDao
import com.yerayyas.gymroutines.core.data.mapper.toDomain
import com.yerayyas.gymroutines.core.domain.model.Exercise
import com.yerayyas.gymroutines.core.domain.model.Workout
import com.yerayyas.gymroutines.workout.domain.repository.WorkoutRepository

class WorkoutRepositoryImpl(
    private val routineDao: RoutineDao,
    private val workoutDao: WorkoutDao,
    private val exerciseDao: ExerciseDao,
    private val workoutSetDao: WorkoutSetDao,
    private val workoutLogDao: WorkoutLogDao
) : WorkoutRepository {

    override suspend fun getAllWorkoutsIdsByRoutine(id: String): List<String> {
        return workoutDao.getWorkoutsByRoutineId(id)
    }

    override suspend fun getWorkoutById(id: String): Workout {
        val exercises = getExercisesForWorkout(id)
        return workoutDao.getWorkoutById(id).toDomain(exercises)
    }


    // TODO: Migrate to Room Relations to avoid manual work

    private suspend fun getExercisesForWorkout(workoutId: String): List<Exercise> {
        val exercises = exerciseDao.getExercisesIdsByWorkoutId(workoutId)
        val fullExercises = mutableListOf<Exercise>()
        exercises.forEach {
            val sets = workoutSetDao.getWorkoutSetByExerciseId(it)
            val exercise = exerciseDao.getExerciseById(it)
            fullExercises.add(exercise.toDomain(sets.map { it.toDomain() }))
        }
        return fullExercises
    }

    override suspend fun getLastWorkoutLogInRoutine(routineId: String): String? {
        val workoutLog = workoutLogDao.getLastWorkoutLogInRoutine(routineId)
        return workoutLog?.workoutId
    }

    override suspend fun getLastWorkoutLogWorkout(workoutId: String): Workout? {
      val lastWorkout = workoutLogDao.getLastWorkout(workoutId)
        val workoutId = lastWorkout?.workoutId ?: return null
        return getWorkoutById(workoutId)
    }
}