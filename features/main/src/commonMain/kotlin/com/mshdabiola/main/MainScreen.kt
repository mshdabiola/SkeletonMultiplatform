/*
 *abiola 2022
 */

package com.mshdabiola.main

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import app.cash.paging.LoadStateError
import app.cash.paging.LoadStateLoading
import app.cash.paging.LoadStateNotLoading
import app.cash.paging.compose.LazyPagingItems
import app.cash.paging.compose.collectAsLazyPagingItems
import coil3.compose.AsyncImage
import com.mshdabiola.model.ImageModel
import com.mshdabiola.mvvn.collectAsStateWithLifecycleCommon
import com.mshdabiola.ui.MainState
import com.mshdabiola.ui.ModelUiState
import com.mshdabiola.ui.ScreenSize
import com.mshdabiola.ui.noteItem

// import org.koin.androidx.compose.koinViewModel

@Composable
internal fun MainRoute(
    screenSize: ScreenSize,
    onShowSnackbar: suspend (String, String?) -> Boolean,
    onClicked: (Long) -> Unit,
    navigateToSetting: () -> Unit,
    navigateToDetail: (Long) -> Unit ,
    viewModel: MainViewModel,
) {
    val mainState = viewModel.mainState.collectAsStateWithLifecycleCommon()
    val timeline = viewModel.timeLine.collectAsLazyPagingItems()

    MainScreen(
        mainState = mainState.value,
        screenSize = screenSize,
        navigateToDetail = navigateToDetail,
        navigateToSetting = navigateToSetting,
        items = timeline,
    )
}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
internal fun MainScreen(
    mainState: MainState = MainState(),
    screenSize: ScreenSize = ScreenSize.COMPACT,
    navigateToDetail: (Long) -> Unit = {},
    navigateToSetting: () -> Unit = {},
    items: LazyPagingItems<ModelUiState>,
) {
    val snackbarHostState = remember {
        SnackbarHostState()
    }

    val scrollableState = rememberLazyListState()

    Scaffold(
        modifier = Modifier, // .semantics { this.testTagsAsResourceId = true },
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Skeleton App")
                },
                actions = {
                    IconButton(onClick = navigateToSetting) {
                        Icon(Icons.Default.Settings, "settings")
                    }
                },
            )
        },
        snackbarHost = { SnackbarHost(snackbarHostState) },
    ) { paddingValues ->
        Column(Modifier.padding(paddingValues)) {

            LazyColumn(
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                state = scrollableState,
                modifier = Modifier
                    .fillMaxSize()
                    .testTag("main:list"),
            ) {
//
                noteItem(items,navigateToDetail)
            }

        }
    }
}
//
// @Preview
// @Composable
// fun MainScreenPreview() {
//    MainScreen(
//        mainState = MainState(),
//       items =listOf(ModelUiState(2, "")).toImmutableList()
//    )
// }

@Composable
fun ItemImage(imageModel: ImageModel) {

    ListItem(
        headlineContent = { Text(imageModel.user ?: "name") },
        leadingContent = {
            AsyncImage(
                modifier = Modifier.size(150.dp),
                model = imageModel.url,
                contentDescription = null,
            )
        },
    )

}
