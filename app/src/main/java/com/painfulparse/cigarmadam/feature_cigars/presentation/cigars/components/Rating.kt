package com.painfulparse.cigarmadam.feature_cigars.presentation.cigars.components

import androidx.compose.foundation.layout.Row
import androidx.compose.material.Icon
import androidx.compose.material.IconToggleButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun RatingBar(
    rating: Int,
    onRatingChange: (Int) -> Unit,
    modifier: Modifier = Modifier,
    isEnabled: Boolean = true,
) {
    Row(
        modifier = modifier
    ) {
        (1..5).forEach { index ->
            IconToggleButton(
                checked = (index <= rating),
                enabled = isEnabled,
                onCheckedChange = {
                    onRatingChange(index)
                }
            ) {
                val tint = if (index <= rating) MaterialTheme.colors.primary else MaterialTheme.colors.onSurface
                Icon(Icons.Filled.Star, contentDescription = null, tint = tint)
            }
        }
    }
}