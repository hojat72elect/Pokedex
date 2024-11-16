package com.aa.android.pokedex.repository

import com.aa.android.pokedex.api.PokemonApi
import com.aa.android.pokedex.api.entity.PokemonDTO
import javax.inject.Inject

class PokemonRepository @Inject constructor(val api: PokemonApi) {

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