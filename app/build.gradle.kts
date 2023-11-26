plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.ch2_ps397.destinology"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.ch2_ps397.destinology"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    extra.apply {
        set("coroutine_version", "1.5.2")
        set("room_coroutines_version", "2.1.0-alpha0")
        set("datastore_version", "1.1.0-alpha06")
        set("ktx_version", "1.9.0")
        set("lifecycle_version", "2.6.2")
        set("navigation_version", "2.7.5")
        set("coil_version", "2.5.0")
        set("retrofit_version", "2.9.0")
        set("okhttp_version", "5.0.0-alpha.2")
        set("google_fonts_version", "1.5.4")
    }

    // Coroutine
    implementation("androidx.room:room-coroutines:${extra["room_coroutines_version"]}")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:${extra["coroutine_version"]}")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:${extra["coroutine_version"]}")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-play-services:${extra["coroutine_version"]}")

    // DataStore
    implementation("androidx.datastore:datastore-android:${extra["datastore_version"]}")


    // Lifecycle
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:${extra["lifecycle_version"]}")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:${extra["lifecycle_version"]}")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:${extra["lifecycle_version"]}")
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:${extra["lifecycle_version"]}")

    // Navigation
    implementation("androidx.navigation:navigation-compose:${extra["navigation_version"]}")

    // Coil
    implementation("io.coil-kt:coil-compose:${extra["coil_version"]}")

    // Retrofit
    implementation("com.squareup.retrofit2:retrofit:${extra["retrofit_version"]}")

    // OkHttp
    implementation("com.squareup.okhttp3:okhttp:${extra["okhttp_version"]}")

    // JSON Converter
    implementation("com.squareup.retrofit2:converter-gson:${extra["retrofit_version"]}")

    // Google Fonts
    implementation("androidx.compose.ui:ui-text-google-fonts:${extra["google_fonts_version"]}")

    implementation("androidx.core:core-ktx:${extra["ktx_version"]}")
    implementation("androidx.activity:activity-compose:1.8.1")
    implementation(platform("androidx.compose:compose-bom:2023.03.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.03.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")
}