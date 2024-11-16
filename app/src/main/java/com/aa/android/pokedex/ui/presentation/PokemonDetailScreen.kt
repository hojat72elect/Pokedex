package com.aa.android.pokedex.ui.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.aa.android.pokedex.viewmodel.DetailsViewModel

@Composable
fun PokemonDetailScreen(viewModel: DetailsViewModel, pokemonName: String) {
    PokemonDetailScreen(pokemonName)
}

/**
 * Shows details for a specific pokemon which was chosen by the user.
 */
@Composable
private fun PokemonDetailScreen(pokemon: String) {

    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(scrollState),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
            painter = rememberImagePainter("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/dream-world/7.svg"),
            contentDescription = "Squirtle",
            modifier = Modifier
                .size(200.dp)
                .fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(18.dp))
        Text(
            modifier = Modifier.padding(vertical = 8.dp),
            text = "Squirtle",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.Start
        ) {

            Text("Height :  5", modifier = Modifier.padding(vertical = 8.dp))
            Text("Weight :  90", modifier = Modifier.padding(vertical = 8.dp))
            Text("Type :  Water", modifier = Modifier.padding(vertical = 8.dp))

            // A list of these:
            Text("hp : 44 - effort points : 0", modifier = Modifier.padding(vertical = 8.dp))

        }

    }
}