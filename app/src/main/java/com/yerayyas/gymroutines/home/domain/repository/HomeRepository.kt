package com.yerayyas.gymroutines.home.domain.repository

import com.yerayyas.gymroutines.core.domain.model.Routine
import kotlinx.coroutines.flow.Flow

interface HomeRepository {

    fun getAllRoutines(): Flow<List<Routine>>

    suspend fun insertRoutine(routine: Routine)

    suspend fun getAllWeightsInLastWeek() : List<Double>
}