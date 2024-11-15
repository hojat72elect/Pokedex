package com.aa.android.pokedex.ui.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp

/**
 * Shows details for a specific pokemon which was chosen by the user.
 */
@Composable
fun PokemonDetailScreen(pokemon: String) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(text = pokemon, fontSize = 24.sp)
    }
}