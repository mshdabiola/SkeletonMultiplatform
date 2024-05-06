/*
 *abiola 2022
 */

@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    id("mshdabiola.android.library")
    id("mshdabiola.android.library.compose")
    id("mshdabiola.android.library.jacoco")
}

android {
    namespace = "com.mshdabiola.setting"
}

kotlin {
//    @OptIn(ExperimentalWasmDsl::class)
//    wasmJs {
//        browser()
//    }
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(project(":modules:data"))

                implementation(project(":modules:mvvn"))
                implementation(project(":modules:ui"))
                api(compose.components.resources)

                implementation(project(":modules:designsystem"))
                implementation(project(":modules:analytics"))

            }
        }


    }
}
task("testClasses")
