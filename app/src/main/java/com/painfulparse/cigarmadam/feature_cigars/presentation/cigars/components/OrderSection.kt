package com.painfulparse.cigarmadam.feature_cigars.presentation.cigars.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.painfulparse.cigarmadam.feature_cigars.domain.util.CigarOrder
import com.painfulparse.cigarmadam.feature_cigars.domain.util.OrderType

@Composable
fun OrderSection(
    modifier: Modifier = Modifier,
    cigarOrder: CigarOrder = CigarOrder.Brand(OrderType.Descending),
    onOrderChange: (CigarOrder) -> Unit
) {
    Column(
        modifier = modifier
    ) {
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            DefaultRadioButton(
                text = "Brand",
                selected = cigarOrder is CigarOrder.Brand,
                onSelect = { onOrderChange(CigarOrder.Brand(cigarOrder.orderType)) }
            )
            Spacer(modifier = Modifier.width(8.dp))
            DefaultRadioButton(
                text = "Date",
                selected = cigarOrder is CigarOrder.Date,
                onSelect = { onOrderChange(CigarOrder.Date(cigarOrder.orderType)) }
            )
            Spacer(modifier = Modifier.width(8.dp))
            DefaultRadioButton(
                text = "Flavor",
                selected = cigarOrder is CigarOrder.Flavor,
                onSelect = { onOrderChange(CigarOrder.Flavor(cigarOrder.orderType)) }
            )
            Spacer(modifier = Modifier.width(8.dp))
            DefaultRadioButton(
                text = "Size",
                selected = cigarOrder is CigarOrder.Size,
                onSelect = { onOrderChange(CigarOrder.Size(cigarOrder.orderType)) }
            )
            Spacer(modifier = Modifier.width(8.dp))
            DefaultRadioButton(
                text = "Wrapper",
                selected = cigarOrder is CigarOrder.Wrapper,
                onSelect = { onOrderChange(CigarOrder.Wrapper(cigarOrder.orderType)) }
            )
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                DefaultRadioButton(
                    text = "Ascending",
                    selected = cigarOrder.orderType is OrderType.Ascending,
                    onSelect = { onOrderChange(cigarOrder.copy(OrderType.Ascending)) }
                )
                Spacer(modifier = Modifier.width(8.dp))
                DefaultRadioButton(
                    text = "Descending",
                    selected = cigarOrder.orderType is OrderType.Descending,
                    onSelect = { onOrderChange(cigarOrder.copy(OrderType.Descending)) }
                )
            }
        }
    }
}