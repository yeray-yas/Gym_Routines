package com.yerayyas.gymroutines.core.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.yerayyas.gymroutines.core.data.local.entities.WorkoutEntity
import com.yerayyas.gymroutines.core.data.local.entities.relations.WorkoutWithExercises

@Dao
interface WorkoutDao {
    @Transaction
    @Query("SELECT * FROM WorkoutEntity WHERE workoutId = :id")
    suspend fun getWorkoutById(id: Long): WorkoutWithExercises

    @Query("SELECT workoutId FROM WorkoutEntity WHERE routineId = :id ORDER BY creationTime ASC")
    suspend fun getWorkoutsByRoutineId(id: Long): List<Long>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWorkout(workout: WorkoutEntity): Long
}
