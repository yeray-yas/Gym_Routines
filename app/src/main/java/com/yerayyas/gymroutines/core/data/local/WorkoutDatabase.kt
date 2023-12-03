package com.yerayyas.gymroutines.core.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.yerayyas.gymroutines.core.data.local.entities.ExerciseEntity
import com.yerayyas.gymroutines.core.data.local.entities.RoutineEntity
import com.yerayyas.gymroutines.core.data.local.entities.WorkoutEntity
import com.yerayyas.gymroutines.core.data.local.entities.WorkoutLogEntity
import com.yerayyas.gymroutines.core.data.local.entities.WorkoutSetEntity

@Database(
    entities = [RoutineEntity::class, WorkoutEntity::class, WorkoutLogEntity::class, ExerciseEntity::class,WorkoutSetEntity::class],
    version = 1
)
abstract class WorkoutDatabase : RoomDatabase() {
    abstract val routineDao: RoutineDao
    abstract val workoutDao: WorkoutDao
    abstract val workoutSetDao: WorkoutSetDao
    abstract val exerciseDao: ExerciseDao
    abstract val workoutLogDao: WorkoutLogDao
}