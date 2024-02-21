package com.mshdabiola.designsystem

import android.R
import android.content.res.Configuration
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mshdabiola.designsystem.component.DetailTopAppBar
import com.mshdabiola.designsystem.component.SkBackground
import com.mshdabiola.designsystem.component.SkButton
import com.mshdabiola.designsystem.component.SkGradientBackground
import com.mshdabiola.designsystem.component.SkLoadingWheel
import com.mshdabiola.designsystem.component.SkOverlayLoadingWheel
import com.mshdabiola.designsystem.component.SkTextField
import com.mshdabiola.designsystem.component.SkTopAppBar
import com.mshdabiola.designsystem.icon.SkIcons
import com.mshdabiola.designsystem.theme.SkTheme

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
