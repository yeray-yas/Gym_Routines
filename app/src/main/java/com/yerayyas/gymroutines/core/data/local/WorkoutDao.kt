package com.yerayyas.gymroutines.core.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.yerayyas.gymroutines.core.data.local.entities.RoutineEntity
import com.yerayyas.gymroutines.core.data.local.entities.WorkoutEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface WorkoutDao {
    @Query("SELECT * FROM WorkoutEntity WHERE workoutId = :id")
     fun getWorkoutById(id:String): WorkoutEntity

    @Query("SELECT workoutId FROM WorkoutEntity WHERE routineId = :id")
    fun getWorkoutsByRoutineId(id:String): List<String>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWorkout(workout: WorkoutEntity)
}
