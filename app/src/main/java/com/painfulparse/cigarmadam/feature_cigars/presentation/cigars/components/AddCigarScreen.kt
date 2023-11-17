package com.painfulparse.cigarmadam.feature_cigars.presentation.cigars.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Icon
import androidx.compose.material.IconToggleButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.painfulparse.cigarmadam.feature_cigars.domain.model.BodyFlavor
import com.painfulparse.cigarmadam.feature_cigars.domain.model.Cigar
import com.painfulparse.cigarmadam.feature_cigars.presentation.cigars.CigarEvent
import com.painfulparse.cigarmadam.feature_cigars.presentation.viewmodel.CigarViewModel

@Composable
fun AddCigarScreen(viewModel: CigarViewModel, navController: NavController) {
    var name by remember { mutableStateOf("") }
    var brand by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    var origin by remember { mutableStateOf("") }
    var selectedBodyFlavor by remember { mutableStateOf("Mild") }
    var rating by remember { mutableStateOf(0) }

    val bodyFlavors = listOf("Mild", "Medium", "Full", "Extra Full")

    val navBackStackEntry by navController.currentBackStackEntryAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Name") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = brand,
            onValueChange = { brand = it },
            label = { Text("Brand") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = description,
            onValueChange = { description = it },
            label = { Text("Description") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = origin,
            onValueChange = { origin = it },
            label = { Text("Origin") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        DropdownMenu(
            bodyFlavors, selectedBodyFlavor, onValueChange = { selectedBodyFlavor = it }, "Body Flavor"
        )
        Spacer(modifier = Modifier.height(8.dp))
        RatingBar(rating = rating, onRatingChange = { rating = it })
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                val newCigar = Cigar(
                    id = 0, // Assuming ID is auto-generated or not required for new entries
                    name = name,
                    brand = brand,
                    origin = origin,
                    description = description,
                    bodyFlavor = BodyFlavor.EXTRA_FULL,
                    rating = rating.toFloat(),
                    imageUri = null,
                    timestamp = System.currentTimeMillis()
                )

                viewModel.onEvent(CigarEvent.AddCigar(newCigar))
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Add Cigar")
        }
    }
}

@Composable
fun DropdownMenu(
    items: List<String>, selectedItem: String, onValueChange: (String) -> Unit, label: String
) {
    var expanded by remember { mutableStateOf(false) }
    Box(modifier = Modifier.fillMaxWidth()) {
        Text(selectedItem, modifier = Modifier.clickable { expanded = true })
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier.fillMaxWidth()
        ) {
            items.forEach { label ->
                DropdownMenuItem(onClick = {
                    onValueChange(label)
                    expanded = false
                }) {
                    Text(text = label)
                }
            }
        }
    }
}
