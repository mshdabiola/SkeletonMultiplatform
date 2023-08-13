
plugins {
    //kotlin("multiplatform")
    id("mshdabiola.mpp.library")
    id("mshdabiola.mpp.library.compose")
}

android {
    namespace = "com.mshdabiola.ui"
}
kotlin {
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(project(":modules:model"))
            }
        }

    }
}
