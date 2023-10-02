package com.baharudin.cuacaku.data.quake

import com.baharudin.cuacaku.data.quake.remote.QuakeApi
import com.baharudin.cuacaku.data.quake.repository.QuakeRepositoryImpl
import com.baharudin.cuacaku.domain.quake.repository.QuakeRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object QuakeModule {
    @Singleton
    @Provides
    fun provideQuakeApi(retrofit : Retrofit) : QuakeApi {
        return retrofit.create(QuakeApi::class.java)
    }

    @Singleton
    @Provides
    fun provideQuakeRepository(quakeApi : QuakeApi) : QuakeRepository {
        return QuakeRepositoryImpl(quakeApi)
    }
}