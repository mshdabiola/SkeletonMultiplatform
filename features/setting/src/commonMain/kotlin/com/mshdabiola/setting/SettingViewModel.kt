/*
 *abiola 2022
 */

package com.mshdabiola.setting

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.mshdabiola.data.repository.IModelRepository
import com.mshdabiola.mvvn.ViewModel
import com.mshdabiola.data.repository.UserDataRepository
import com.mshdabiola.model.Contrast
import com.mshdabiola.model.DarkThemeConfig
import com.mshdabiola.model.Model
import com.mshdabiola.model.ThemeBrand
import com.mshdabiola.model.UserData
import kotlinx.collections.immutable.toImmutableList
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import kotlin.random.Random

class SettingViewModel constructor(
    private val userDataRepository: UserDataRepository,
) : ViewModel() {
    private val default = UserData(
        useDynamicColor = false,
        themeBrand = ThemeBrand.DEFAULT,
        contrast = Contrast.Normal,
        darkThemeConfig = DarkThemeConfig.LIGHT,
        shouldHideOnboarding = true,
    )
    val uiState: StateFlow<SettingState> = userDataRepository.userData.map {
        SettingState(it)
    }.stateIn(
        scope = viewModelScope,
        initialValue = SettingState(
            default,
        ),
        started = SharingStarted.WhileSubscribed(5_000),
    )

    fun setThemeBrand(themeBrand: ThemeBrand) {
        viewModelScope.launch {
            userDataRepository.setThemeBrand(themeBrand)
        }
    }

    fun setThemeContrast(contrast: Contrast) {
        viewModelScope.launch {
            userDataRepository.setThemeContrast(contrast)
        }
    }

    /**
     * Sets the desired dark theme config.
     */
    fun setDarkThemeConfig(darkThemeConfig: DarkThemeConfig) {
        viewModelScope.launch {
            userDataRepository.setDarkThemeConfig(darkThemeConfig)
        }
    }
}
