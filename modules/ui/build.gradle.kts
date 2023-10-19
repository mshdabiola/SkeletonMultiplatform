
plugins {
    kotlin("multiplatform")
    id("com.android.library")
    id("org.jetbrains.compose") version libs.versions.composePlugin
}

android {
    compileSdk = 34
    namespace = "com.mshdabiola.ui"
//    buildFeatures {
//        compose = true
//    }
    kotlin {
        jvmToolchain(17)
    }
//    composeOptions {
//        kotlinCompilerExtensionVersion = libs.versions.androidxComposeCompiler.toString()
//    }

}
//compose {
//    kotlinCompilerPlugin.set(compose.kotlinCompilerPlugin)
////    val kotlinVersion = project.property("kotlin.version") as String
////    kotlinCompilerPluginArgs.add("suppressKotlinVersionCompatibilityCheck=$kotlinVersion")
//}

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
                implementation(compose.preview)
                implementation(libs.androidx.compose.material3.windowSizeClass)
            }
        }
//        val androidMain by getting {
//            dependencies {
//
//            }
//        }
//        val desktopMain by getting {
//            dependencies {
//                implementation(compose.preview)
//
//            }
//        }

    }
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
    kotlinOptions {
        jvmTarget = "17"
    }
}