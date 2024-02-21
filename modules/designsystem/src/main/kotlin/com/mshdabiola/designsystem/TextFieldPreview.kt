package com.mshdabiola.designsystem

import android.content.res.Configuration
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mshdabiola.designsystem.component.SkBackground
import com.mshdabiola.designsystem.component.SkButton
import com.mshdabiola.designsystem.component.SkGradientBackground
import com.mshdabiola.designsystem.component.SkLoadingWheel
import com.mshdabiola.designsystem.component.SkOverlayLoadingWheel
import com.mshdabiola.designsystem.component.SkTextField
import com.mshdabiola.designsystem.icon.SkIcons
import com.mshdabiola.designsystem.theme.SkTheme

@Preview
@Composable
private fun SkTextFieldPreview() {
    SkTextField(value = "Sk Testing")
}
