package com.painfulparse.cigarmadam.feature_cigars.presentation.cigars.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.painfulparse.cigarmadam.feature_cigars.presentation.viewmodel.CigarViewModel

@Composable
fun CigarListScreen(viewModel: CigarViewModel, navController: NavController) {
    val cigarList = viewModel.state.value.cigars

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Cigar Madam") },
                backgroundColor = MaterialTheme.colors.primary,
                contentColor = Color.White,
                elevation = 10.dp,
                actions = {
                    IconButton(onClick = { navController.navigate("AddCigarScreen") }) {
                        Icon(Icons.Filled.Add, contentDescription = "Add Cigar")
                    }
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .background(MaterialTheme.colors.onPrimary),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            LazyColumn {
                items(cigarList) { cigar ->
                    CigarItem(cigar = cigar) {
                        // Handle item click if needed
                    }
                }
            }
        }
    }
}
