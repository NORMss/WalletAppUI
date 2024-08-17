package com.norm.mywalletappui.components

import android.widget.Space
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Gamepad
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.toFontFamily
import com.norm.mywalletappui.R

@Composable
fun SpendingSection(modifier: Modifier = Modifier) {

}

@Composable
fun SpendingSelection(modifier: Modifier = Modifier) {
    Text(
        text = "Spending Breakdown",
        fontFamily = Font(R.font.jetbrainsmono).toFontFamily(),
        fontSize = 25.sp,
    )
    Spacer(
        modifier = Modifier
            .height(16.dp)
    )

    SpendingList()
}

@Composable
fun SpendingList(modifier: Modifier = Modifier) {
    LazyRow(
        modifier = modifier,
        contentPadding = PaddingValues(horizontal = 16.dp)
    ) {
        items(spendingItems.size) { index ->
            SpendingItem()
        }
    }
}

@Composable
fun SpendingItem(
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
                .background(spendingItem.color)
        ) {

        }
    }
}

val spendingItems = listOf(
    SpendingItem(
        name = "Steam",
        amount = "₽234,00",
        color = Color.Gray,
        icon = Icons.Default.Gamepad,
    )
)

data class SpendingItem(
    val name: String,
    val amount: Float,
    val color: Color,
    val icon: ImageVector,
)