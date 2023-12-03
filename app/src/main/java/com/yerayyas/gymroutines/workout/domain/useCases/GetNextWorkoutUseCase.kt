package com.yerayyas.gymroutines.workout.domain.useCases

import com.yerayyas.gymroutines.core.domain.model.Workout
import com.yerayyas.gymroutines.workout.domain.repository.WorkoutRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GetNextWorkoutUseCase(private val repository: WorkoutRepository) {
    suspend operator fun invoke(routineId:String): Workout {

        return withContext(Dispatchers.IO) {
            // 1- Obtener todos los workouts de la rutina
            val workouts = repository.getAllWorkoutsIdsByRoutine(routineId)
             repository.getWorkoutById(workouts.first())
        }

        // 2- Obtener todos los logs de esa rutina
        // 3- Verificar cual fue el último workout
        // 4- Crear el nuevo workout

    }
}