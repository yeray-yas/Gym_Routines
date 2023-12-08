package com.yerayyas.gymroutines.core.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.yerayyas.gymroutines.core.data.local.entities.WorkoutLogEntity
import com.yerayyas.gymroutines.core.data.local.entities.relations.WorkoutLogWithWorkout

@Dao
interface WorkoutLogDao {
    @Query("SELECT * FROM WorkoutLogEntity WHERE workoutLogId = :id")
    suspend fun getWorkoutLogById(id: Long): WorkoutLogEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun createWorkoutLog(workoutLogEntity: WorkoutLogEntity): Long

    @Query("SELECT * FROM WorkoutLogEntity WHERE routineId = :id ORDER BY date DESC LIMIT 1")
    suspend fun getLastWorkoutLogInRoutine(id: Long): WorkoutLogEntity?

    @Transaction
    @Query("SELECT * FROM WorkoutLogEntity WHERE workoutId = :id ORDER BY date DESC LIMIT 1")
    suspend fun getLastWorkout(id: Long): WorkoutLogWithWorkout?

    @Delete
    suspend fun deleteWorkoutLogById(workoutLogEntity: WorkoutLogEntity)

    @Query("SELECT COUNT(workoutLogId) FROM WorkoutLogEntity WHERE routineId = :id")
    suspend fun countAllWorkoutLogs(id: Long): Int
}
