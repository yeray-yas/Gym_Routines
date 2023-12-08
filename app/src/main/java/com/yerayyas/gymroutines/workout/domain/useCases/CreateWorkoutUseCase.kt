package com.yerayyas.gymroutines.workout.domain.useCases

import com.yerayyas.gymroutines.core.domain.model.Workout
import com.yerayyas.gymroutines.workout.domain.repository.WorkoutRepository

class CreateWorkoutUseCase(private val repository: WorkoutRepository) {
    suspend operator fun invoke(workoutId: Long): Workout {
        val workoutLogWorkout = repository.getLastWorkoutLogWorkout(workoutId)
        return workoutLogWorkout ?: repository.getWorkoutById(workoutId)
    }
}