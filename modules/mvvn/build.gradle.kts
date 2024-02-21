@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    id("mshdabiola.android.library")
    id("mshdabiola.android.library.compose")

}

android {
    namespace = "com.mshdabiola.mvvn"
}

kotlin {
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(libs.kotlinx.coroutines.core)
                implementation(compose.runtime)
                implementation(compose.ui)

            }
        }

        val commonTest by getting {
            dependencies {

            }
        }

        val androidMain by getting {
            dependencies {

                implementation(libs.koin.core)
                implementation(libs.koin.android)
                implementation(libs.koin.android.compose)

                implementation(libs.androidx.core.ktx)



                implementation(libs.androidx.lifecycle.runtimeCompose)
                implementation(libs.androidx.lifecycle.viewModelCompose)
            }
        }


        val desktopMain by getting {
            dependencies {

            }
        }

        val desktopTest by getting

//        val jsMain by getting {
//            dependencies {
//
//            }
//        }
    }
}