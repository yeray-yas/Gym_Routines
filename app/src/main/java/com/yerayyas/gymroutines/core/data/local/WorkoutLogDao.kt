package com.yerayyas.gymroutines.core.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.yerayyas.gymroutines.core.data.local.entities.WorkoutLogEntity

@Dao
interface WorkoutLogDao {
    @Query("SELECT * FROM WorkoutLogEntity WHERE workoutLogId = :id")
     fun getWorkoutLogById(id:String): WorkoutLogEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun createWorkoutLogById(workoutLogEntity: WorkoutLogEntity)

    @Delete
    suspend fun deleteWorkoutLogById(workoutLogEntity: WorkoutLogEntity)
}
