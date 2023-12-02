package com.yerayyas.gymroutines.home.domain.useCases

import com.yerayyas.gymroutines.core.domain.model.Routine
import com.yerayyas.gymroutines.home.domain.repository.HomeRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetRoutinesUseCase @Inject constructor(private val repository: HomeRepository) {
    operator fun invoke(): Flow<List<Routine>> {
        return repository.getAllRoutines()
    }
}