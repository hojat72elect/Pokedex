package com.aa.android.pokedex.repository

import com.aa.android.pokedex.api.PokemonApi
import com.aa.android.pokedex.api.entity.PokemonDTO
import javax.inject.Inject
import retrofit2.Retrofit

class PokemonRepository @Inject constructor(retrofit: Retrofit) {

    private val api: PokemonApi = retrofit.create(PokemonApi::class.java)

    suspend fun getAllPokemon(): List<String> {
        val response = api.getAllPokemon()
        if (response.isSuccessful) {
            response.body()?.let {
                return it.results.map { result ->
                    result.name
                }
            }
        }
        return listOf()
    }

    suspend fun getSinglePokemon(name: String): PokemonDTO? {
        val response = api.getPokemon(name)
        return if (response.isSuccessful)
            response.body()
        else
            null
    }
}