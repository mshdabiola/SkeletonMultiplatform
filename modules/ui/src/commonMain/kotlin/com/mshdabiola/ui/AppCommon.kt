package com.mshdabiola.ui

import org.koin.dsl.module
import com.mshdabiola.mvvn.commonViewModel

val commonModule = module{
    commonViewModel{CommonViewModel()}
}
