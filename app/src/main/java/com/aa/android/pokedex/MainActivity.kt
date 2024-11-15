package com.aa.android.pokedex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.aa.android.pokedex.model.UiState
import com.aa.android.pokedex.ui.presentation.PokemonDetailScreen
import com.aa.android.pokedex.ui.presentation.PokemonListScreen
import com.aa.android.pokedex.ui.theme.PokedexTheme
import com.aa.android.pokedex.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PokedexTheme {
                Screen(mainViewModel.pokemonLiveData)
            }
        }
    }
}

@Composable
fun Screen(pokemon: LiveData<UiState<List<String>>>) {
    Scaffold(topBar = {
        TopAppBar(backgroundColor = MaterialTheme.colors.primary, title = {
            Image(painter = painterResource(id = R.drawable.pokemon_logo), null)
        })
    }) {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(it),
            color = MaterialTheme.colors.background
        ) {
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = "pokemonList") {
                composable("pokemonList") { PokemonListScreen(pokemon, navController) }
                composable(
                    "pokemonDetail/{pokemon}", arguments = listOf(navArgument("pokemon") {
                        type = NavType.StringType
                    })
                ) { backStackEntry ->
                    val chosenPokemon = backStackEntry.arguments?.getString("pokemon") ?: ""
                    PokemonDetailScreen(chosenPokemon)
                }
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    PokedexTheme {
        Screen(MutableLiveData(UiState.Ready(listOf("one", "two", "three"))))
    }
}