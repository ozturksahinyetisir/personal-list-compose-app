package com.ozturksahinyetisir.personalappquiz.di

import com.ozturksahinyetisir.personalappquiz.network.EmployeeService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
                return Retrofit.Builder()
                    .baseUrl("https://dummy.restapiexample.com")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
    }

    @Provides
    @Singleton
    fun provideEmployeeService(retrofit: Retrofit): EmployeeService {
        return retrofit.create(EmployeeService::class.java)
    }
}