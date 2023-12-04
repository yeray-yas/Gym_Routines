package com.yerayyas.gymroutines.core.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.yerayyas.gymroutines.core.data.local.entities.ExerciseEntity

@Dao
interface ExerciseDao {
    @Query("SELECT * FROM ExerciseEntity WHERE workoutId = :workoutId")
    suspend fun getExercisesByWorkoutId(workoutId: String): List<ExerciseEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertExercise(exercise: ExerciseEntity)

    @Query("SELECT exerciseId FROM ExerciseEntity WHERE workoutId = :id")
    suspend fun getExercisesIdsByWorkoutId(id: String): List<String>

    @Query("SELECT * FROM ExerciseEntity WHERE exerciseId = :id")
    suspend fun getExerciseById(id: String): ExerciseEntity
}
