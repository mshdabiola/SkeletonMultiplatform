@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    id("mshdabiola.android.library")
}

android {
    namespace = "com.mshdabiola.data"
}

kotlin {
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(project(":modules:model"))

                implementation(libs.koin.core)
                //   implementation(libs.kermit.log)
                implementation(project(":modules:model"))
                implementation(project(":modules:database"))
                implementation(project(":modules:setting"))
                implementation(project(":modules:network"))
                implementation(libs.kotlinx.coroutines.core)
            }
        }

    }
}