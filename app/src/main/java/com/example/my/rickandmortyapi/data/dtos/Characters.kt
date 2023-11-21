package com.example.my.rickandmortyapi.data.dtos

import android.icu.text.IDNA

data class Characters(
    val info: IDNA.Info,
    val results: List<Result>
)