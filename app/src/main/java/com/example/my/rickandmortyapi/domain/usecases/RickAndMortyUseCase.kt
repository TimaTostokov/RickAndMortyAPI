package com.example.my.rickandmortyapi.domain.usecases

import com.example.my.rickandmortyapi.domain.model.RickAndMortyModel
import com.example.my.rickandmortyapi.domain.repositories.RickAndMortyRepository
import com.example.my.rickandmortyapi.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class RickAndMortyUseCase @Inject constructor(private val repository: RickAndMortyRepository) {
    suspend operator fun invoke(): Flow<Resource<List<RickAndMortyModel>>> = flow {
        try {
            emit(Resource.Loading())
            val data = repository.getCharacters().results.map { }
//            emit(Resource.Success(data))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "HTTP Error"))
        } catch (e: IOException) {
            emit(Resource.Error("Network Error"))
        }
    }

}