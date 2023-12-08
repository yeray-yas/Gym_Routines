package com.yerayyas.gymroutines.home.data.repository

import com.yerayyas.gymroutines.core.data.local.ExerciseDao
import com.yerayyas.gymroutines.core.data.local.RoutineDao
import com.yerayyas.gymroutines.core.data.local.WorkoutDao
import com.yerayyas.gymroutines.core.data.local.WorkoutLogDao
import com.yerayyas.gymroutines.core.data.local.WorkoutSetDao
import com.yerayyas.gymroutines.core.data.mapper.toDomain
import com.yerayyas.gymroutines.core.data.mapper.toEntity
import com.yerayyas.gymroutines.core.domain.model.Routine
import com.yerayyas.gymroutines.home.domain.repository.HomeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class HomeRepositoryImpl(
    private val routineDao: RoutineDao,
    private val workoutDao: WorkoutDao,
    private val exerciseDao: ExerciseDao,
    private val workoutSetDao: WorkoutSetDao,
    private val workoutLogDao: WorkoutLogDao
) : HomeRepository {

    override fun getAllRoutines(): Flow<List<Routine>> {
        return routineDao.getAllRoutines().map { routines -> routines.map { it.toDomain() } }
    }

    override suspend fun insertRoutine(routine: Routine) {
        val routineId = routineDao.insertRoutine(routine.toEntity())
        routine.workouts.forEach { workout ->
            val workoutId = workoutDao.insertWorkout(workout.toEntity(routineId))
            workout.exercises.forEach { exercise ->
                val exerciseId = exerciseDao.insertExercise(exercise.toEntity(workoutId ))
                exercise.sets.forEach { set ->
                    workoutSetDao.insertWorkoutSet(set.toEntity(exerciseId))
                }
            }
        }
    }
}