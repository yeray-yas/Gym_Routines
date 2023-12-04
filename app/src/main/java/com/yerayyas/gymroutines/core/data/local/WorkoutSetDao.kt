package com.yerayyas.gymroutines.core.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.yerayyas.gymroutines.core.data.local.entities.WorkoutSetEntity

@Dao
interface WorkoutSetDao {
    @Query("SELECT * FROM WorkoutSetEntity WHERE exerciseId = :exerciseId")
    suspend fun getWorkoutSetByExerciseId(exerciseId: String): List<WorkoutSetEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWorkoutSet(set: WorkoutSetEntity)
}
