package com.yerayyas.gymroutines.workout.domain.useCases

import com.yerayyas.gymroutines.core.domain.model.Workout
import com.yerayyas.gymroutines.workout.domain.repository.WorkoutRepository
import java.util.UUID


class CreateWorkoutUseCase(private val repository: WorkoutRepository) {
    suspend operator fun invoke(workoutId: String): Workout {
        val workout = repository.getWorkoutById(workoutId)
        val workoutLogWorkout = repository.getLastWorkoutLogWorkout(workoutId)
        return workoutLogWorkout?.copy(
            id = UUID.randomUUID().toString()
        ) ?: workout.copy(id = UUID.randomUUID().toString())
    }
}