import org.jetbrains.kotlin.gradle.targets.js.dsl.ExperimentalWasmDsl

/*
 *abiola 2024
 */
@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    id("mshdabiola.android.library")
    id("mshdabiola.android.library.compose")
//    id("mshdabiola.android.library.jacoco")
}

android {
    defaultConfig {
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    namespace = "com.mshdabiola.ui"
}

dependencies {
    api(libs.androidx.metrics)


    implementation(libs.coil.kt)
    implementation(libs.coil.kt.compose)

    androidTestImplementation(project(":modules:testing"))
}

kotlin{
    @OptIn(ExperimentalWasmDsl::class)
    wasmJs {
        browser()
    }
    sourceSets{
        val desktopMain by getting{
            dependencies{

            }
        }

        val commonMain by getting{
            dependencies{
                api(project(":modules:analytics"))
                api(project(":modules:designsystem"))
                api(project(":modules:model"))
            }
        }
    }
}
