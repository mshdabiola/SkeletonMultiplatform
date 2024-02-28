import androidx.compose.runtime.mutableStateOf
import com.mshdabiola.model.Contrast
import com.mshdabiola.model.DarkThemeConfig
import com.mshdabiola.model.ThemeBrand
import com.mshdabiola.model.UserData
import com.mshdabiola.mvvn.ViewModel
import com.mshdabiola.network.INetworkDataSource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class MainViewModel(
    private val iNetworkDataSource: INetworkDataSource
) : ViewModel() {

    val uiState: StateFlow<MainActivityUiState> = MutableStateFlow(
        MainActivityUiState.Success(
        UserData(
            useDynamicColor = false,
            themeBrand = ThemeBrand.DEFAULT,
            contrast = Contrast.Normal,
            darkThemeConfig = DarkThemeConfig.LIGHT,
            shouldHideOnboarding = true
        )))
    init {
        viewModelScope.launch {
            iNetworkDataSource.goToGoogle()
        }
    }
}


sealed interface MainActivityUiState {
    data object Loading : MainActivityUiState
    data class Success(val userData: UserData) : MainActivityUiState
}
