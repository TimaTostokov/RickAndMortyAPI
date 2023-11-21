package com.example.my.rickandmortyapi.data.apiservise

import com.example.my.rickandmortyapi.data.dtos.Characters
import com.example.my.rickandmortyapi.util.Constant
import retrofit2.http.GET

interface RickAndMortyApiService {
    @GET(Constant.END_POINT)
    suspend fun getCharacters(): Characters
}