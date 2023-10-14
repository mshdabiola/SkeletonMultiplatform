
plugins {
    kotlin("multiplatform")
    id("com.android.library")
    id("org.jetbrains.compose") version libs.versions.composePlugin
}

android {
    //configureAndroidCompose(this)
    compileSdk = 34
    namespace = "com.mshdabiola.designsystem"
    kotlin {
        jvmToolchain(17)
    }
}
kotlin {
    androidTarget()
    jvm("desktop")
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(compose.runtime)
                implementation(compose.foundation)
                implementation(compose.material3)
                implementation(compose.materialIconsExtended) // TODO not working on iOS for now
                @OptIn(org.jetbrains.compose.ExperimentalComposeLibrary::class)
                implementation(compose.components.resources)
                implementation(project(":modules:model"))
            }
        }

    }
}



tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
    kotlinOptions {
        jvmTarget = "17"
    }
}