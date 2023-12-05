package com.yerayyas.gymroutines.core.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.yerayyas.gymroutines.core.data.local.entities.ExerciseEntity
import com.yerayyas.gymroutines.core.data.local.entities.relations.ExerciseWithSets

@Dao
interface ExerciseDao {

    @Transaction
    @Query("SELECT * FROM ExerciseEntity WHERE workoutId = :workoutId")
    suspend fun getExercisesByWorkoutId(workoutId: String): List<ExerciseWithSets>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertExercise(exercise: ExerciseEntity): Long

    @Query("SELECT exerciseId FROM ExerciseEntity WHERE workoutId = :id")
    suspend fun getExercisesIdsByWorkoutId(id: String): List<Int>

    @Transaction
    @Query("SELECT * FROM ExerciseEntity WHERE exerciseId = :id")
    suspend fun getExerciseById(id: Int): ExerciseWithSets
}
