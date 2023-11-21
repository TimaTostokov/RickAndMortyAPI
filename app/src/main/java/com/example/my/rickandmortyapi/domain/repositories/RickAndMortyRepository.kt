package com.example.my.rickandmortyapi.domain.repositories

import com.example.my.rickandmortyapi.data.dtos.Characters

interface RickAndMortyRepository {
    suspend fun getCharacters(): Characters
}