package com.mshdabiola.desktop.ui.feature.main

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Android
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.mshdabiola.ui.MyCard
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.splitpane.ExperimentalSplitPaneApi
import org.jetbrains.compose.splitpane.HorizontalSplitPane
import org.jetbrains.compose.splitpane.rememberSplitPaneState


@OptIn(ExperimentalSplitPaneApi::class)
@Composable
fun MainScreen(
    viewModel: MainViewModel,
) {
    val welcomeText by viewModel.welcomeText.collectAsState()

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = welcomeText,
                style = MaterialTheme.typography.headlineMedium
            )

            Spacer(
                modifier = Modifier.height(10.dp)
            )

            Button(
                onClick = {
                    viewModel.onClickMeClicked()
                }
            ) {
                Text(text = "click me")
            }
            //Text("Test")
            MyCard()
        }
    }
}

@OptIn(ExperimentalSplitPaneApi::class, ExperimentalResourceApi::class)
@Preview
@Composable
fun id() {
    MaterialTheme{

        val state= rememberSplitPaneState(0.5f,true)
        HorizontalSplitPane(splitPaneState = state) {
            splitter {
                this.visiblePart {
                    Box(Modifier.background(Color.Yellow).width(10.dp).fillMaxHeight())
                }
                handle {
                    Box(Modifier.background(Color.Blue).width(20.dp).fillMaxHeight().markAsHandle())
                }
            }
          first {

              Image(painter = painterResource("drawables/logo.png"),"")



              Text("Abiola")  }
            second {    Button(onClick = {}, content = {
                Text("Click")
                Icon(Icons.Default.Android,contentDescription = null)
            })}
        }


    }

}