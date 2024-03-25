@file:Suppress("PackageDirectoryMismatch")

object Config {

    object Project {
        const val compileSdk = 33
        const val minSdkView = 16
        const val targetSdk = 33
        const val buildToolsVersion = "30.0.3"
    }

    object BuildPlugins {
        const val buildGradlePlugin = "com.android.tools.build:gradle:_"
        const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:_"
        const val ktlintGradlePlugin = "org.jlleitschuh.gradle:ktlint-gradle:_"
        const val paparazziPlugin = "app.cash.paparazzi:paparazzi-gradle-plugin:_"
    }

    object Libs {

        object Android {
            const val coreKtx = "androidx.core:core-ktx:_"
        }
    }
}
