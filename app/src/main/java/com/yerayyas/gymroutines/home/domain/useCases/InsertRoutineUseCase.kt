package com.yerayyas.gymroutines.home.domain.useCases

import com.yerayyas.gymroutines.core.domain.model.Routine
import com.yerayyas.gymroutines.home.domain.repository.HomeRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class InsertRoutineUseCase @Inject constructor(private val repository: HomeRepository) {
    suspend operator fun invoke(routine: Routine) {
        return repository.insertRoutine(routine)
    }
}