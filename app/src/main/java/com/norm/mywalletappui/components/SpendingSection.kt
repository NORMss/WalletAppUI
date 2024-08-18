package com.norm.mywalletappui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.DirectionsRun
import androidx.compose.material.icons.rounded.Gamepad
import androidx.compose.material.icons.rounded.ShoppingCart
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.toFontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.norm.mywalletappui.R
import com.norm.mywalletappui.randomColor

@Composable
fun SpendingList(modifier: Modifier = Modifier) {
    LazyRow(
        modifier = modifier,
        contentPadding = PaddingValues(horizontal = 16.dp)
    ) {
        itemsIndexed(spendingItems) { index, spendingItem ->
            SpendingElement(
                spendingItem = spendingItem
            )
            Spacer(
                modifier = Modifier
                    .width(16.dp)
            )
        }
    }
}

@Composable
fun SpendingSelection(modifier: Modifier = Modifier) {
    Text(
        modifier = Modifier
            .padding(
                horizontal = 22.dp
            ),
        text = "Spending Statistics",
        fontFamily = Font(R.font.jetbrainsmono).toFontFamily(),
        fontSize = 25.sp,
    )
    Spacer(
        modifier = Modifier
            .height(16.dp)
    )

    SpendingList(
        modifier = modifier,
    )
}

@Composable
fun SpendingElement(
    modifier: Modifier = Modifier,
    spendingItem: SpendingItem,
) {
    ElevatedCard(
        onClick = {

        },
        modifier = modifier.size(150.dp),
        shape = RoundedCornerShape(20.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .background(spendingItem.color.copy(alpha = 0.5f))
                .padding(20.dp),
            verticalArrangement = Arrangement.SpaceBetween,

            ) {
            Icon(
                imageVector = spendingItem.icon,
                contentDescription = spendingItem.name,
                tint = Color.Black.copy(alpha = 0.8f),
                modifier = Modifier
                    .size(33.dp)
            )

            Text(
                text = spendingItem.name,
                fontFamily = Font(R.font.newamsterdam).toFontFamily(),
                fontSize = 15.sp,
                color = Color.Black.copy(0.7f),
            )
            Text(
                text = "₽ ${spendingItem.amount}",
                fontFamily = Font(R.font.jetbrainsmono).toFontFamily(),
                fontSize = 20.sp,
                color = Color.Black,
            )

        }
    }
}

val spendingItems = listOf(
    SpendingItem(
        name = "Games",
        amount = 234.5F,
        color = randomColor(),
        icon = Icons.Rounded.Gamepad,
    ),
    SpendingItem(
        name = "Sport",
        amount = 1256.6F,
        color = randomColor(),
        icon = Icons.AutoMirrored.Rounded.DirectionsRun,
    ),
    SpendingItem(
        name = "Markets",
        amount = 2576.0F,
        color = randomColor(),
        icon = Icons.Rounded.ShoppingCart,
    ),
)

data class SpendingItem(
    val name: String,
    val amount: Float,
    val color: Color,
    val icon: ImageVector,
)