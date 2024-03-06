import com.mshdabiola.analytics.di.analyticsModule
import com.mshdabiola.mvvn.commonViewModel
import com.mshdabiola.network.di.networkModule
import org.koin.dsl.module

val appModule= module {
    includes(analyticsModule, networkModule)
    commonViewModel { MainViewModel(get()) }
}