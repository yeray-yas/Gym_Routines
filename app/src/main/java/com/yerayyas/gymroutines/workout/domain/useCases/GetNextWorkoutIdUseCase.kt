package com.yerayyas.gymroutines.workout.domain.useCases

import com.yerayyas.gymroutines.workout.domain.repository.WorkoutRepository


class GetNextWorkoutIdUseCase(private val repository: WorkoutRepository) {
    suspend operator fun invoke(routineId: String): String {
        // 1- Obtener todos los workouts de la rutina
        val workouts = repository.getAllWorkoutsIdsByRoutine(routineId)
        // 2- Contar cuantos logs hay
        val workoutCount = repository.countAllWorkoutLogs(routineId)
        // 3- Devolver la siguiente rutina basada en los logs
        return workouts[workoutCount!! % workouts.size]

    }
}