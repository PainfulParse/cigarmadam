package com.painfulparse.cigarmadam.feature_cigars.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.painfulparse.cigarmadam.feature_cigars.presentation.cigars.components.AddCigarScreen
import com.painfulparse.cigarmadam.feature_cigars.presentation.cigars.components.CigarListScreen
import com.painfulparse.cigarmadam.ui.theme.CigarMadamTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CigarMadamTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    CigarMadamApp()
                }
            }
        }
    }

    @Composable
    fun CigarMadamApp() {
        val navController = rememberNavController()
        NavHost(navController = navController, startDestination = "cigarListScreen") {
            composable("cigarListScreen") { CigarListScreen(navController) }
            composable("addCigarScreen") { AddCigarScreen(navController) }
        }
    }
}
