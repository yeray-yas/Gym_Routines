package com.yerayyas.gymroutines.workout.domain.useCases

import com.yerayyas.gymroutines.workout.domain.repository.WorkoutRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


class GetNextWorkoutIdUseCase(private val repository: WorkoutRepository) {
    suspend operator fun invoke(routineId: String): String {

        return withContext(Dispatchers.IO) {
            // 1- Obtener todos los workouts de la rutina
            val workouts = repository.getAllWorkoutsIdsByRoutine(routineId)

            // 2- Obtener último log de la rutina por workout
            val lastWorkoutId = repository.getLastWorkoutLogInRoutine(routineId)

            // 3- Devolver el id del siguiente workout
            if (lastWorkoutId == null) {
                workouts.first()
            } else {
                val index = workouts.indexOf(lastWorkoutId)
                if (workouts.size > index) {
                    workouts[index + 1]
                } else {
                    workouts.first()
                }
            }
        }
    }
}