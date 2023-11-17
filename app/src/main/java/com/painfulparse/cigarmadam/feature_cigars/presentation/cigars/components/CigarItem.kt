package com.painfulparse.cigarmadam.feature_cigars.presentation.cigars.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.painfulparse.cigarmadam.feature_cigars.domain.model.BodyFlavor
import com.painfulparse.cigarmadam.feature_cigars.domain.model.Cigar
import com.painfulparse.cigarmadam.ui.theme.CigarMadamTypography
import java.time.Instant

@Composable
fun CigarItem(
    cigar: Cigar,
    modifier: Modifier = Modifier,
    onDeleteClick: () -> Unit,
) {
    Card(
        modifier = modifier
            .height(80.dp)
            .background(MaterialTheme.colors.background)
            .fillMaxWidth()

    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Column {
                Text(
                    text = "${cigar.brand} ${cigar.name}",
                    style = CigarMadamTypography.h2,
                )
                Text(
                    text = "Rating ${cigar.rating.toInt()} out of 5",
                    style = CigarMadamTypography.body1,
                )
            }
            Column() {
                IconButton(
                    onClick = onDeleteClick,
                    modifier = Modifier
                        .align(Alignment.End)
                ) {
                    val tint = MaterialTheme.colors.primary
                    Icon(Icons.Filled.Delete, contentDescription = "delete", tint = tint)
                }
            }
        }
    }
}

@Preview
@Composable
private fun CigarItem_Preview() {
    CigarItem(
        cigar = Cigar(
            name = "Broadleaf",
            brand = "Powstanie",
            description = "Robusto shape with a broadleaf binder",
            bodyFlavor = BodyFlavor.MEDIUM,
            origin = "",
            rating = 4.2f,
            timestamp = Instant.now().toEpochMilli(),
            id = 0
        ),
        onDeleteClick = {}
    )
}