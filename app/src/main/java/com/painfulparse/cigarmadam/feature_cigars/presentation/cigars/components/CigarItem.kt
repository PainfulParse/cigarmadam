package com.painfulparse.cigarmadam.feature_cigars.presentation.cigars.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.painfulparse.cigarmadam.feature_cigars.domain.model.Cigar

@Composable
fun CigarItem(
    cigar: Cigar,
    modifier: Modifier = Modifier,
    cornerRadius: Dp = 10.dp,
    onDeleteClick: () -> Unit,
) {
    Card(
        modifier = Modifier
            .padding(5.dp)
            .height(80.dp)
            .background(MaterialTheme.colors.background)
            .fillMaxWidth()

    ) {
        Text(
            text = cigar.name
        )
    }
}