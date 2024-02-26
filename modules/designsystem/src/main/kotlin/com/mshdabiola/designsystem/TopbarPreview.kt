package com.mshdabiola.designsystem

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.mshdabiola.designsystem.component.DetailTopAppBar

@OptIn(ExperimentalMaterial3Api::class)
@Preview("Top App Bar")
@Composable
private fun SkTopAppBarPreview() {
//    SkTopAppBar(
//        titleRes = R.string.untitled,
//        navigationIcon = SkIcons.Search,
//        navigationIconContentDescription = "Navigation icon",
//        actionIcon = SkIcons.MoreVert,
//        actionIconContentDescription = "Action icon",
//    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview("Top App Bar")
@Composable
private fun DetailTopAppBarPreview() {
    DetailTopAppBar()
}
