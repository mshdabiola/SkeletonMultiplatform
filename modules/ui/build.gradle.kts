plugins {
    id("mshdabiola.mpp.feature")
}

android {
    namespace = "com.mshdabiola.ui"

}

kotlin {
    androidTarget()
    jvm("desktop")
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(project(":modules:data"))
                implementation(libs.decompose.core)
                implementation(libs.decompose.compose.jetbrains)

                implementation(project(":modules:mvvn"))
                implementation(project(":modules:navigation"))

                implementation(project(":modules:designsystem"))

            }
        }
        val androidMain by getting {
            dependencies {

//                implementation(project(":modules:navigation"))


                implementation(libs.koin.core)
                implementation(libs.koin.android)
                implementation(libs.koin.android.compose)

                implementation(libs.androidx.core.ktx)



                implementation(libs.androidx.lifecycle.runtimeCompose)


            }
        }

        val desktopMain by getting {
            dependencies {
                @OptIn(org.jetbrains.compose.ExperimentalComposeLibrary::class)
                implementation(compose.desktop.components.splitPane)
                @OptIn(org.jetbrains.compose.ExperimentalComposeLibrary::class)
                implementation(compose.desktop.components.animatedImage)
            }
        }


    }
}


//    kotlin {
//        jvmToolchain(17)
//    }