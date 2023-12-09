package com.yerayyas.gymroutines.workout.data.repository

import com.yerayyas.gymroutines.core.data.local.ExerciseDao
import com.yerayyas.gymroutines.core.data.local.WorkoutDao
import com.yerayyas.gymroutines.core.data.local.WorkoutLogDao
import com.yerayyas.gymroutines.core.data.local.WorkoutSetDao
import com.yerayyas.gymroutines.core.data.mapper.toDomain
import com.yerayyas.gymroutines.core.data.mapper.toEntity
import com.yerayyas.gymroutines.core.domain.model.Workout
import com.yerayyas.gymroutines.core.domain.model.WorkoutLog
import com.yerayyas.gymroutines.workout.domain.repository.WorkoutRepository

class WorkoutRepositoryImpl(
    private val workoutDao: WorkoutDao,
    private val exerciseDao: ExerciseDao,
    private val workoutSetDao: WorkoutSetDao,
    private val workoutLogDao: WorkoutLogDao
) : WorkoutRepository {

    override suspend fun getAllWorkoutsIdsByRoutine(routineId: Long): List<Long> {
        return workoutDao.getWorkoutsByRoutineId(routineId)
    }

    override suspend fun getWorkoutById(id: Long): Workout {
        return workoutDao.getWorkoutById(id).toDomain()
    }

    override suspend fun countAllWorkoutLogs(routineId: Long): Int {
        return workoutLogDao.countAllWorkoutLogs(routineId)
    }

    override suspend fun getLastWorkoutLogWorkout(workoutId: Long): Workout? {
        val lastWorkoutLog = workoutLogDao.getLastWorkout(workoutId)
        val lastWorkout = lastWorkoutLog?.workout ?: return null
        return lastWorkout.toDomain()
    }

    override suspend fun saveWorkout(routineId: Long, workoutLog: WorkoutLog) {
        // Sets the ids to null on each item (workout, exercise, set) so it creates a new one
        // Useful if we want to show a progress history or similar
        val workout = workoutLog.workout.copy(id = null)
        val workoutId = workoutDao.insertWorkout(workout.toEntity(routineId))
        val log = workoutLog.copy(workout = workout.copy(id = workoutId))
        workoutLogDao.createWorkoutLog(log.toEntity(routineId))
        workout.exercises.forEach { exercise ->
            val exerciseId = exerciseDao.insertExercise(exercise.copy(id = null).toEntity(workoutId))
            exercise.sets.forEach { set ->
                workoutSetDao.insertWorkoutSet(set.copy(id = null).toEntity(exerciseId))
            }
        }
    }
}