package com.yerayyas.gymroutines.core.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.yerayyas.gymroutines.core.data.local.entities.RoutineEntity
import com.yerayyas.gymroutines.core.data.local.entities.WorkoutEntity
import com.yerayyas.gymroutines.core.data.local.entities.WorkoutLogEntity

@Database(
    entities = [RoutineEntity::class, WorkoutEntity::class, WorkoutLogEntity::class],
    version = 1
)
abstract class WorkoutDatabase : RoomDatabase() {
    abstract val routineDao: RoutineDao
    abstract val workoutDao: WorkoutDao
    abstract val workoutLogDao: WorkoutLogDao
}