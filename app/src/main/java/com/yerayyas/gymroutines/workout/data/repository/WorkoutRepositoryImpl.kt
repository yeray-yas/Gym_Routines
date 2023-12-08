package com.yerayyas.gymroutines.workout.data.repository

import com.yerayyas.gymroutines.core.data.local.ExerciseDao
import com.yerayyas.gymroutines.core.data.local.RoutineDao
import com.yerayyas.gymroutines.core.data.local.WorkoutDao
import com.yerayyas.gymroutines.core.data.local.WorkoutLogDao
import com.yerayyas.gymroutines.core.data.local.WorkoutSetDao
import com.yerayyas.gymroutines.core.data.mapper.toDomain
import com.yerayyas.gymroutines.core.data.mapper.toEntity
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

    override suspend fun getAllWorkoutsIdsByRoutine(routineId: Long): List<Long> {
        return workoutDao.getWorkoutsByRoutineId(routineId)
    }

    override suspend fun getWorkoutById(id: Long): Workout {
        return workoutDao.getWorkoutById(id).toDomain()
    }

    override suspend fun getLastWorkoutLogInRoutine(routineId: Long): Long? {
        val workoutLog = workoutLogDao.getLastWorkoutLogInRoutine(routineId)
        return workoutLog?.workoutId
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
        val workout = workoutLog.workout.copy(id = null)
        val log = workoutLog.copy(workout = workout)
        workoutLogDao.createWorkoutLog(log.toEntity(routineId))
       val workoutId = workoutDao.insertWorkout(workout.toEntity(routineId))
        workout.exercises.forEach { exercise ->
            val exerciseId = exerciseDao.insertExercise(exercise.toEntity(workoutId))
            exercise.sets.forEach { set ->
                workoutSetDao.insertWorkoutSet(set.toEntity(exerciseId))
            }
        }
    }
}