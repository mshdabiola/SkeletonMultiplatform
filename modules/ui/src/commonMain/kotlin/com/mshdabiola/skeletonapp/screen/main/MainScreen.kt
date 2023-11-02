package com.mshdabiola.skeletonapp.screen.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import com.mshdabiola.mvvn.KoinCommonViewModel
import com.mshdabiola.mvvn.collectAsStateWithLifecycleCommon
import kotlinx.collections.immutable.ImmutableList

//import org.koin.androidx.compose.koinViewModel

@Composable
internal fun MainScreen(onBack: () -> Unit) {
    val viewModel: MainViewModel = KoinCommonViewModel()
    val mainState = viewModel.mainState.collectAsStateWithLifecycleCommon()
    val modelst = viewModel.modelState.collectAsStateWithLifecycleCommon()

    MainScreen(
        back = onBack,
        mainState = mainState.value,
        items = modelst.value,
        setName = viewModel::addName
    )
}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
internal fun MainScreen(
    mainState: MainState = MainState(),
    back: () -> Unit = {},
    items: ImmutableList<ModelUiState>,
    setName: (String) -> Unit = {}
) {
    val snackbarHostState = remember {
        SnackbarHostState()
    }
//    LaunchedEffect(key1 = mainState.messages, block = {
//        Timber.d(mainState.messages.joinToString())
//    })
    var name by remember {
        mutableStateOf("")
    }
//    NotifySnacker(snackHostState = snackbarHostState, notifys = mainState.messages)
    Scaffold(
        modifier = Modifier,//.semantics { this.testTagsAsResourceId = true },
        topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(onClick = back) {
                        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "back")
                    }
                },
                title = {
                    Text(text = "name")
                },
            )
        },
        snackbarHost = { SnackbarHost(snackbarHostState) }
    ) { paddingValues ->
        Column(Modifier.padding(paddingValues)) {
            TextField(
                modifier = Modifier.fillMaxWidth(),
                value = name,
                placeholder = { Text(text = "Enter text") },
                onValueChange = { name = it },
            )
            Button(
                modifier = Modifier.testTag("button"),
                onClick = {
                    setName(name)
                    name = ""

                }) {
                Text(text = "Add Test")
            }
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            ) {
                items(items) {
                    Text(text = it.name)
                }
            }
        }
    }
}
//
//@Preview
//@Composable
//fun MainScreenPreview() {
//    MainScreen(
//        mainState = MainState(),
//       items =listOf(ModelUiState(2, "")).toImmutableList()
//    )
//}

@Composable
expect fun MainScreenPreview()
