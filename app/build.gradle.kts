@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
    // id("com.apollographql.apollo3")
}

android {
    val androidCompileSdk: Int by rootProject.extra
    val androidTargetSdk: Int by rootProject.extra
    val androidMinSdk: Int by rootProject.extra

    compileSdk = androidCompileSdk
    defaultConfig {
        applicationId = "com.ohp.app"
        minSdk = androidMinSdk
        targetSdk = androidTargetSdk
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }
    buildTypes {
        release {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
        freeCompilerArgs = listOf("-Xopt-in=kotlin.RequiresOptIn")
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.androidx.composeCompiler.get()
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    // AndroidX
    implementation(libs.androidx.coreKtx)
    implementation(libs.androidx.activity.compose)

    // AndroidX Lifecycle
    implementation(libs.androidx.lifecycle.runtimeKtx)

    // AndroidX Compose
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.uiToolingPreview)
    implementation(libs.androidx.compose.material)
    androidTestImplementation(libs.androidx.compose.uiTestJUnit4)
    debugImplementation(libs.androidx.compose.uiTooling)
    debugImplementation(libs.androidx.compose.uiTestManifest)

    // Accompanist
    implementation(libs.accompanist.navigationMaterial)

    // AndroidX Test
    androidTestImplementation(libs.androidx.test.extJUnit)
    androidTestImplementation(libs.androidx.test.espresso.core)

    // Hilt
    implementation(libs.hilt.android)
    implementation(libs.hilt.navCompose)
    kapt(libs.hilt.compiler)

    // Other
    testImplementation(libs.junit)
}