package com.yerayyas.gymroutines.core.data.local

import androidx.room.Dao
import androidx.room.Query
import com.yerayyas.gymroutines.core.data.local.entities.RoutineEntity
import com.yerayyas.gymroutines.core.data.local.entities.WorkoutEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface WorkoutDao {
    @Query("SELECT * FROM WorkoutEntity WHERE workoutId = :id")
     fun getWorkoutById(id:String): WorkoutEntity
}
