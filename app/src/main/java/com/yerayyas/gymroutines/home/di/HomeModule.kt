package com.yerayyas.gymroutines.home.di

import com.yerayyas.gymroutines.core.data.local.ExerciseDao
import com.yerayyas.gymroutines.core.data.local.RoutineDao
import com.yerayyas.gymroutines.core.data.local.WorkoutDao
import com.yerayyas.gymroutines.core.data.local.WorkoutSetDao
import com.yerayyas.gymroutines.home.data.repository.HomeRepositoryImpl
import com.yerayyas.gymroutines.home.domain.repository.HomeRepository
import com.yerayyas.gymroutines.home.domain.useCases.GetRoutinesUseCase
import com.yerayyas.gymroutines.home.domain.useCases.InsertRoutineUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class HomeModule {

    @Singleton
    @Provides
    fun provideHomeRepository(
        routineDao: RoutineDao,
        workoutDao: WorkoutDao,
        workoutSetDao: WorkoutSetDao,
        exerciseDao: ExerciseDao
    ): HomeRepository {
        return HomeRepositoryImpl(routineDao, workoutDao, exerciseDao, workoutSetDao)
    }

    @Singleton
    @Provides
    fun provideGetAllRoutinesUseCase(repository: HomeRepository): GetRoutinesUseCase {
        return GetRoutinesUseCase(repository)
    }

    @Singleton
    @Provides
    fun provideInsertRoutine(repository: HomeRepository): InsertRoutineUseCase {
        return InsertRoutineUseCase(repository)
    }
}