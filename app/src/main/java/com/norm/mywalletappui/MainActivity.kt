package com.norm.mywalletappui

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.unit.dp
import com.norm.mywalletappui.components.ActionSection
import com.norm.mywalletappui.components.CardSection
import com.norm.mywalletappui.components.TopBar
import com.norm.mywalletappui.ui.theme.MyWalletAppUITheme

@OptIn(ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.Q)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(
                state = rememberTopAppBarState()
            )
            MyWalletAppUITheme {
                Scaffold(
                    modifier = Modifier
                        .nestedScroll(
                            scrollBehavior.nestedScrollConnection
                        ),
                    topBar = {
                        TopBar(
                            modifier = Modifier
                                .fillMaxWidth(),
                            scrollBehavior = scrollBehavior,
                        )
                    }
                ) { paddingValues ->
                    MainScreen(
                        modifier = Modifier
                            .padding(
                                top = paddingValues.calculateTopPadding(),
                                bottom = paddingValues.calculateTopPadding(),
                            )
                    )
                }
            }
        }
    }
}

@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .verticalScroll(rememberScrollState()),
    ) {
        Spacer(
            modifier = Modifier
                .height(30.dp)
        )
        CardSection(
            modifier = Modifier
                .fillMaxWidth(),
        )
        Spacer(
            modifier = Modifier
                .height(20.dp),
        )
        ActionSection(
            modifier = Modifier
                .fillMaxWidth(),
        )
    }
}