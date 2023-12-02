package com.yerayyas.gymroutines.home.di

import com.yerayyas.gymroutines.home.data.repository.HomeRepositoryImpl
import com.yerayyas.gymroutines.home.domain.repository.HomeRepository
import com.yerayyas.gymroutines.home.domain.useCases.GetRoutinesUseCase
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
    fun provideHomeRepository(): HomeRepository {
        return HomeRepositoryImpl()
    }

    @Singleton
    @Provides
    fun provideGetAllRoutines(repository: HomeRepository):GetRoutinesUseCase{
        return GetRoutinesUseCase(repository)
    }
}