import org.jetbrains.compose.ExperimentalComposeLibrary
import org.jetbrains.compose.desktop.application.dsl.TargetFormat
import org.jetbrains.kotlin.gradle.targets.js.dsl.ExperimentalWasmDsl

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsCompose)
}

kotlin {
    @OptIn(ExperimentalWasmDsl::class)
    wasmJs {
        moduleName = "composeApp"
        browser {
            commonWebpackConfig {
                outputFileName = "composeApp.js"
            }
        }
        binaries.executable()
    }
    
    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }
    
    jvm("desktop")
    
    sourceSets {
        val desktopMain by getting
        
        androidMain.dependencies {
            implementation(libs.compose.ui.tooling.preview)
            implementation(libs.androidx.activity.compose)
        }
        commonMain.dependencies {
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material)
            implementation(compose.ui)
            @OptIn(ExperimentalComposeLibrary::class)
            implementation(compose.components.resources)
            implementation(project(":shared"))
        }
        desktopMain.dependencies {
            implementation(compose.desktop.currentOs)
            implementation(project(":modules:designsystem"))
            implementation(project(":modules:app"))
            implementation(libs.kotlinx.coroutines.swing)

            implementation(libs.decompose.core)
            implementation(libs.decompose.compose.jetbrains)
            implementation(libs.koin.core)
        }
    }
}

android {
    namespace = "com.mshdabiola.skeletonapp"
    compileSdk = 34

    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    sourceSets["main"].res.srcDirs("src/androidMain/res")
    sourceSets["main"].resources.srcDirs("src/commonMain/resources")

    defaultConfig {
        applicationId = "com.mshdabiola.skeletonapp"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    dependencies {
        debugImplementation(libs.compose.ui.tooling)
    }
}

compose.desktop {
    application {
        mainClass = "com.mshdabiola.desktop.MainAppKt"
        /*
        * Its unreliable. Don't run release tasks for now.
        * Wait until fixed: https://github.com/JetBrains/compose-jb/issues/2393
        */

        buildTypes.release.proguard {
            configurationFiles.from(project.file("compose-desktop.pro"))
            obfuscate.set(true)
            version.set("7.3.0")
        }

        val iconsRoot = project.file("src/main/resources/drawables/launcher")
        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageVersion = "1.0.1"
            packageName = "Skeleton"
            description = "Template"
            copyright = "© 2022 Mshdabiola. All rights reserved."
            vendor = "Mshdabiola App"
            version = "1.0.1"
            licenseFile.set(rootProject.file("LICENSE"))

            modules("java.net.http", "java.sql")

            linux {
                iconFile.set(iconsRoot.resolve("linux.png"))
                debMaintainer = "mshdabiola@gmail.com"
                menuGroup = packageName
                appCategory = "Productivity"
            }

            windows {
                iconFile.set(iconsRoot.resolve("windows.ico"))
                shortcut = true
                menuGroup = packageName
                //https://wixtoolset.org/documentation/manual/v3/howtos/general/generate_guids.html
                upgradeUuid = "791AC64E-C9A7-4CBF-A1C4-AFE5CFFDDDFA"
            }

            macOS {
                iconFile.set(iconsRoot.resolve("macos.icns"))
                bundleID = "com.mshdabiola.skeleton"
                appCategory = "public.app-category.productivity"
                signing {
                    sign.set(false)
                }
            }
        }
    }
}


compose.experimental {
    web.application {}
}