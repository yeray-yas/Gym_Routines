package com.yerayyas.gymroutines.home.data.repository

import com.yerayyas.gymroutines.core.data.local.FakeDatabase
import com.yerayyas.gymroutines.core.domain.model.Exercise
import com.yerayyas.gymroutines.core.domain.model.Routine
import com.yerayyas.gymroutines.core.domain.model.Workout
import com.yerayyas.gymroutines.core.domain.model.WorkoutSet
import com.yerayyas.gymroutines.home.data.mappers.toDomain
import com.yerayyas.gymroutines.home.domain.repository.HomeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import java.util.UUID

class HomeRepositoryImpl : HomeRepository {

    override fun getAllRoutines(): Flow<List<Routine>> {
        val routine = FakeDatabase.fakeRoutine.toDomain()
        return flowOf(
            listOf(routine),
        )
    }
}