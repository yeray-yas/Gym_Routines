package com.yerayyas.gymroutines.core.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.yerayyas.gymroutines.core.data.local.entities.RoutineEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface RoutineDao {
    @Transaction
    @Query("SELECT * FROM RoutineEntity")
     fun getAllRoutines(): Flow<List<RoutineEntity>>

     @Insert(onConflict = OnConflictStrategy.REPLACE)
     suspend fun insertRoutine(routine: RoutineEntity)
}
