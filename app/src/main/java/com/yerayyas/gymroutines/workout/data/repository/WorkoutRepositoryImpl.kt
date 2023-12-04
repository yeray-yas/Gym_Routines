package com.yerayyas.gymroutines.workout.data.repository

import com.yerayyas.gymroutines.core.data.local.ExerciseDao
import com.yerayyas.gymroutines.core.data.local.RoutineDao
import com.yerayyas.gymroutines.core.data.local.WorkoutDao
import com.yerayyas.gymroutines.core.data.local.WorkoutLogDao
import com.yerayyas.gymroutines.core.data.local.WorkoutSetDao
import com.yerayyas.gymroutines.core.data.mapper.toDomain
import com.yerayyas.gymroutines.core.data.mapper.toEntity
import com.yerayyas.gymroutines.core.domain.model.Exercise
import com.yerayyas.gymroutines.core.domain.model.Workout
import com.yerayyas.gymroutines.core.domain.model.WorkoutLog
import com.yerayyas.gymroutines.workout.domain.repository.WorkoutRepository
import java.util.UUID

class WorkoutRepositoryImpl(
    private val routineDao: RoutineDao,
    private val workoutDao: WorkoutDao,
    private val exerciseDao: ExerciseDao,
    private val workoutSetDao: WorkoutSetDao,
    private val workoutLogDao: WorkoutLogDao
) : WorkoutRepository {

    override suspend fun getAllWorkoutsIdsByRoutine(routineId: String): List<String> {
        return workoutDao.getWorkoutsByRoutineId(routineId)
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

    override suspend fun countAllWorkoutLogs(routineId: String): Int {
        return workoutLogDao.countAllWorkoutLogs(routineId)
    }

    override suspend fun getLastWorkoutLogWorkout(workoutId: String): Workout? {
        val lastWorkout = workoutLogDao.getLastWorkout(workoutId)
        val lastWorkoutId = lastWorkout?.workoutId ?: return null

        return getWorkoutById(lastWorkoutId)
    }

    override suspend fun saveWorkout(routineId: String, workoutLog: WorkoutLog) {
        val workout = workoutLog.workout.copy(id = UUID.randomUUID().toString())
        val log = workoutLog.copy(workout = workout)
        workoutLogDao.createWorkoutLog(log.toEntity(routineId))
        workoutDao.insertWorkout(workout.toEntity(routineId))
        workout.exercises.forEach { exercise ->
            val updatedExercise = exercise.toEntity(workout.id).copy(exerciseId = UUID.randomUUID().toString())
            exerciseDao.insertExercise(updatedExercise)
            exercise.sets.forEach { set ->

                val updatedSet = set.toEntity(updatedExercise.exerciseId).copy(
                    workoutSetId = null
                )
                workoutSetDao.insertWorkoutSet(updatedSet)
            }
        }
    }
}