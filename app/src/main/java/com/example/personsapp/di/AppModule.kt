package com.example.personsapp.di

import com.example.personsapp.data.datasource.KisilerDataSource
import com.example.personsapp.data.repository.KisilerRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideKisilerDataSource(): KisilerDataSource {
        return KisilerDataSource()

    }

    fun provideKisilerRepository(kds: KisilerDataSource): KisilerRepository {
        return KisilerRepository(kds)

    }


}