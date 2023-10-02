package com.baharudin.cuacaku.domain.di

import com.baharudin.cuacaku.domain.quake.usecase.GetQuakeUseCase
import com.baharudin.cuacaku.domain.quake.usecase.QuakeUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    @Singleton
    fun provideQuakeUseCase(
        getQuake : GetQuakeUseCase
    ) : QuakeUseCase {
        return QuakeUseCase(getQuake)
    }
}