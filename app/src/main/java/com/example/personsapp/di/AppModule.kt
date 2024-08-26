package com.example.personsapp.di

import android.content.Context
import androidx.room.Room
import com.example.personsapp.data.datasource.KisilerDataSource
import com.example.personsapp.data.repository.KisilerRepository
import com.example.personsapp.room.AppDatabase
import com.example.personsapp.room.KisilerDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideKisilerDataSource(kdao: KisilerDao): KisilerDataSource {
        return KisilerDataSource(kdao)

    }

    @Provides
    @Singleton
    fun provideKisilerRepository(kds: KisilerDataSource): KisilerRepository {
        return KisilerRepository(kds)

    }

    @Provides
    @Singleton
    fun provideKisilerDao(@ApplicationContext context: Context): KisilerDao {
        val db = Room.databaseBuilder(context, AppDatabase::class.java, "rehber.sqlite")
            .createFromAsset("rehber.sqlite").build()
        return db.getKisilerDao()
    }


}