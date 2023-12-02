package com.yerayyas.gymroutines.workout.di

import com.yerayyas.gymroutines.home.domain.repository.HomeRepository
import com.yerayyas.gymroutines.home.domain.useCases.GetRoutinesUseCase
import com.yerayyas.gymroutines.workout.data.repository.WorkoutRepositoryImpl
import com.yerayyas.gymroutines.workout.domain.repository.WorkoutRepository
import com.yerayyas.gymroutines.workout.domain.useCases.GetNextWorkoutUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class WorkoutModule {

    @Singleton
    @Provides
    fun provideWorkoutRepository(): WorkoutRepository {
        return WorkoutRepositoryImpl()
    }

    @Singleton
    @Provides
    fun provideGetWorkoutUseCase(repository: WorkoutRepository): GetNextWorkoutUseCase {
        return GetNextWorkoutUseCase(repository)
    }
}