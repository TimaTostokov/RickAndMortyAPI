package com.example.my.rickandmortyapi.presentation.viewmodel

import com.example.my.rickandmortyapi.domain.model.RickAndMortyModel

data class RickAndMortyStates(
    val load: Boolean = false,
    val success: List<RickAndMortyModel> = emptyList(),
    val fail: String = ""
)