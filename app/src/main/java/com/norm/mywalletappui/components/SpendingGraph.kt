package com.norm.mywalletappui.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.toFontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.norm.mywalletappui.R
import com.norm.mywalletappui.randomColor
import me.bytebeats.views.charts.bar.BarChart
import me.bytebeats.views.charts.bar.BarChartData
import me.bytebeats.views.charts.bar.render.label.SimpleLabelDrawer
import me.bytebeats.views.charts.bar.render.xaxis.SimpleXAxisDrawer
import me.bytebeats.views.charts.bar.render.yaxis.SimpleYAxisDrawer

@Composable
fun SpendingGraph(modifier: Modifier = Modifier) {
    Text(
        modifier = Modifier
            .padding(
                horizontal = 22.dp
            ),
        text = "Spending Breakdown",
        fontFamily = Font(R.font.jetbrainsmono).toFontFamily(),
        fontSize = 25.sp,
    )
    Spacer(
        modifier = Modifier
            .height(16.dp)
    )

    Chart(
        modifier = modifier,
    )
}

@Composable
fun Chart(modifier: Modifier = Modifier) {
    BarChart(
        modifier = modifier,
        barChartData = BarChartData(spendingByData),
        xAxisDrawer = SimpleXAxisDrawer(
            axisLineThickness = 2.dp,
            axisLineColor = MaterialTheme.colorScheme.onBackground.copy(0.2f)
        ),
        yAxisDrawer = SimpleYAxisDrawer(
            labelValueFormatter = {
                "₽ ${it.toInt()}"
            },
            labelTextColor = MaterialTheme.colorScheme.onBackground,
            axisLineThickness = 2.dp,
            axisLineColor = MaterialTheme.colorScheme.onBackground.copy(0.2f),
        ),
        labelDrawer = SimpleLabelDrawer(
            drawLocation = SimpleLabelDrawer.DrawLocation.Outside,
            labelTextSize = 15.sp,
            labelTextColor = MaterialTheme.colorScheme.onBackground,
        )
    )
}

val spendingByData = listOf(
    BarChartData.Bar(
        label = "18 Aug",
        value = 452.5f,
        color = randomColor(52),
    ),
    BarChartData.Bar(
        label = "19 Aug",
        value = 63.1f,
        color = randomColor(52),
    ),
    BarChartData.Bar(
        label = "20 Aug",
        value = 1892.5f,
        color = randomColor(52),
    ),
    BarChartData.Bar(
        label = "21 Aug",
        value = 129.0f,
        color = randomColor(52),
    ),
)

