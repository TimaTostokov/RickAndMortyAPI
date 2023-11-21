package com.example.my.rickandmortyapi.di

import com.example.my.rickandmortyapi.data.apiservise.RickAndMortyApiService
import com.example.my.rickandmortyapi.data.repositories.RickAndMortyRepositoryImpl
import com.example.my.rickandmortyapi.domain.repositories.RickAndMortyRepository
import com.example.my.rickandmortyapi.util.Constant
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ModuleApp {

    @Singleton
    @Provides
    fun providesRetrofit(): RickAndMortyApiService = Retrofit.Builder()
        .baseUrl(Constant.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(RickAndMortyApiService::class.java)

    @Singleton
    @Provides
    fun providesRepository(apiService: RickAndMortyApiService): RickAndMortyRepository =
        RickAndMortyRepositoryImpl(apiService)

}