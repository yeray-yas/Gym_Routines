package com.yerayyas.gymroutines.workout.domain.useCases

import com.yerayyas.gymroutines.core.domain.model.WorkoutLog
import com.yerayyas.gymroutines.workout.domain.repository.WorkoutRepository

class FinishWorkoutUseCase(private val repository: WorkoutRepository) {
    suspend operator fun invoke(routineId: String, workoutLog: WorkoutLog) {
        repository.saveWorkout(routineId, workoutLog)
    }
}