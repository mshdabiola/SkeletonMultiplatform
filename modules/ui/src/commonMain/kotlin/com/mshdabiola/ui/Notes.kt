/*
 *abiola 2022
 */

package com.mshdabiola.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mshdabiola.analytics.LocalAnalyticsHelper

@OptIn(ExperimentalFoundationApi::class)
fun LazyListScope.noteItem(
    feedMainState: MainState,
    onClick: (Long) -> Unit = {},
) {
    when (feedMainState) {
        MainState.Loading -> Unit
        is MainState.Success -> {
            items(
                items = feedMainState.noteUiStates,
                key = { it.id },
                contentType = { "newsFeedItem" },
            ) { note ->
                val analyticsHelper = LocalAnalyticsHelper.current

                NoteUi(
                    noteUiState = note,
                    onClick = {
                        analyticsHelper.logNoteOpened(
                            newsResourceId = note.id.toString(),
                        )
                        onClick(note.id)
                        // launchCustomChromeTab(context, Uri.parse(""), backgroundColor)
                    },
                    modifier = Modifier
                        .padding(horizontal = 8.dp)
                        .animateItemPlacement(),
                )
            }
        }
    }
}

@Composable
fun NoteUi(
    modifier: Modifier,
    noteUiState: NoteUiState,
    onClick: (Long) -> Unit,
) {
    ListItem(
        modifier = modifier.clickable { onClick(noteUiState.id) },
        headlineContent = { Text(text = noteUiState.title) },
        supportingContent = { Text(text = noteUiState.description) },
    )
}

sealed interface MainState {
    data object Loading : MainState
    data class Success(
        val noteUiStates: List<NoteUiState>,
    ) : MainState
}

data class NoteUiState(
    val id: Long,
    val title: String,
    val description: String,
)
//
// @Preview
// @Composable
// private fun NoteUiPreview() {
//    SkTheme {
//        LazyColumn {
//            noteItem(
//                feedMainState = MainState.Loading,
//            )
//        }
//    }
// }
