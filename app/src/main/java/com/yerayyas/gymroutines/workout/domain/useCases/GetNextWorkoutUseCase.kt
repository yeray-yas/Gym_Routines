package com.yerayyas.gymroutines.workout.domain.useCases

import com.yerayyas.gymroutines.core.domain.model.Workout
import com.yerayyas.gymroutines.workout.domain.repository.WorkoutRepository

class GetNextWorkoutUseCase(private val repository: WorkoutRepository) {
    suspend operator fun invoke(routineId:String): Workout {
        // 1- Obtener todos los workouts de la rutina
        // 2- Obtener todos los logs de esa rutina
        // 3- Verificar cual fue el último workout
        // 4- Crear el nuevo workout

        return repository.getAllWorkoutsByRoutine(routineId).first()
    }
}