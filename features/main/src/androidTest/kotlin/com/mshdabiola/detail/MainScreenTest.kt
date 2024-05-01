/*
 *abiola 2022
 */

package com.mshdabiola.detail

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import com.mshdabiola.main.MainScreen
import com.mshdabiola.ui.MainState
import com.mshdabiola.ui.NoteUiState
import org.junit.Rule
import org.junit.Test

/**
 * UI tests for [MainScreen] composable.
 */
class MainScreenTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    @Test
    fun enterText_showsShowText() {
        composeTestRule.setContent {
            MainScreen(
                mainState = MainState.Success(
                    listOf(
                        NoteUiState(
                            id = 5257L,
                            title = "Jacinto",
                            description = "Charisma",
                        ),
//                    NoteUiState(id = 7450L, title = "Dewayne", description = "Justan"),
//                    NoteUiState(id = 1352L, title = "Bjorn", description = "Daquan"),
//                    NoteUiState(id = 4476L, title = "Tonya", description = "Ivelisse"),
//                    NoteUiState(id = 6520L, title = "Raegan", description = "Katrena"),
//                    NoteUiState(id = 5136L, title = "Markis", description = "Giles"),
//                    NoteUiState(id = 6868L, title = "Virgilio", description = "Ashford"),
//                    NoteUiState(id = 7100L, title = "Larae", description = "Krystyn"),
//                    NoteUiState(id = 3210L, title = "Nigel", description = "Sergio"),
//                    NoteUiState(id = 7830L, title = "Kristy", description = "Jacobi"),
//                    NoteUiState(id = 1020L, title = "Kathlene", description = "Shlomo"),
//                    NoteUiState(id = 3365L, title = "Corin", description = "Ross"),

                    ),
                ),
                onClick = {},
                onShowSnackbar = { _, _ -> false },
            )
        }

        composeTestRule
            .onNodeWithTag("main:list")
            .assertExists()
    }
}
