package com.yerayyas.gymroutines.workout.domain.useCases

import com.yerayyas.gymroutines.core.domain.model.Workout
import com.yerayyas.gymroutines.core.domain.model.WorkoutLog
import com.yerayyas.gymroutines.workout.domain.repository.WorkoutRepository
import java.time.LocalDate

class FinishWorkoutUseCase(private val repository: WorkoutRepository) {
    suspend operator fun invoke(routineId: Long, bodyWeight: Double, workout: Workout) {
        val workoutLog = WorkoutLog(
            id = null,
            bodyWeight = bodyWeight,
            date = LocalDate.now().minusDays(6),
            workout = workout
        )
        repository.saveWorkout(routineId, workoutLog)
    }
}