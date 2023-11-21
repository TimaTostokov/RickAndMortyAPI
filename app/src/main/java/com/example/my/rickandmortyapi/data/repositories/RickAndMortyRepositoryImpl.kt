package com.example.my.rickandmortyapi.data.repositories

import com.example.my.rickandmortyapi.data.apiservise.RickAndMortyApiService
import com.example.my.rickandmortyapi.data.dtos.Characters
import com.example.my.rickandmortyapi.domain.repositories.RickAndMortyRepository
import javax.inject.Inject

class RickAndMortyRepositoryImpl @Inject constructor(private val apiService: RickAndMortyApiService):
    RickAndMortyRepository {
    override suspend fun getCharacters(): Characters = apiService.getCharacters()
}