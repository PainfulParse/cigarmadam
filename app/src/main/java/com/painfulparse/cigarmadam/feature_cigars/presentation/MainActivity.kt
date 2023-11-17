package com.painfulparse.cigarmadam.feature_cigars.presentation

import CigarMadamTheme
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.painfulparse.cigarmadam.feature_cigars.presentation.cigars.components.AddCigarScreen
import com.painfulparse.cigarmadam.feature_cigars.presentation.cigars.components.CigarListScreen
import com.painfulparse.cigarmadam.feature_cigars.presentation.viewmodel.CigarViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CigarMadamTheme {
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
            composable("cigarListScreen") {
                val viewModel: CigarViewModel = hiltViewModel(it)
                CigarListScreen(viewModel, navController)
            }
            composable("addCigarScreen") {
                val viewModel: CigarViewModel = hiltViewModel(it)
                AddCigarScreen(viewModel, navController)
            }
        }
    }
}
