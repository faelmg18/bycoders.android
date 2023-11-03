plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("com.google.devtools.ksp") version ("1.8.10-1.0.9")
    id("kotlin-parcelize")
}

android {
    namespace = "com.example.bycodersexchange"
    compileSdk = 34
    buildToolsVersion = "33.0.2"

    defaultConfig {
        applicationId = "com.example.bycodersexchange"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    buildFeatures {
        buildConfig = true
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            buildConfigField("String", "API_KEY", "\"sua chave aqui\"")
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }

        debug {
            buildConfigField("String", "API_KEY", "\"sua chave aqui\"")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    sourceSets {
        getByName("main").java.srcDir("src/main/kotlin")
        getByName("main").java.srcDir("build/generated/ksp/main/kotlin")
        getByName("test").java.srcDir("src/test/kotlin")
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Versions.COMPOSE_COMPILER
    }
    buildFeatures {
        compose = true
        viewBinding = true
    }
}

dependencies {

    implementation(Dependencies.Libs.Android.ANDROIDX_CORE)
    implementation(Dependencies.Libs.Android.ANDROIDX_APPCOMPAT)
    implementation(Dependencies.Libs.Android.ANDROID_MATERIAL)

    implementation(Dependencies.Libs.Koin.KOIN_CORE)
    implementation(Dependencies.Libs.Koin.KOIN_ANDROID)
    implementation(Dependencies.Libs.Koin.KOIN_ANDROIDX_COMPOSE)
    implementation(Dependencies.Libs.Koin.KOIN_ANNOTATIONS)
    ksp(Dependencies.Libs.Koin.KOIN_KSP)

    implementation(Dependencies.Libs.Compose.COMPOSE_TOOLING)
    implementation(Dependencies.Libs.Compose.COMPOSE_MATERIAL)

    implementation(Dependencies.Libs.Retrofit.RETROFIT2)
    implementation(Dependencies.Libs.Retrofit.RETROFIT2_CONVERTER)

    testImplementation(Dependencies.Libs.AndroidTest.JUNIT)
    testImplementation(Dependencies.Libs.AndroidTest.MOCKK)
    androidTestImplementation(Dependencies.Libs.AndroidTest.ANDROIDX_TEST_EXT)
    androidTestImplementation(Dependencies.Libs.AndroidTest.TEST_ESPRESSO)
    testImplementation(Dependencies.Libs.AndroidTest.ROBOLECTRIC)
    testImplementation(Dependencies.Libs.AndroidTest.KOIN_TEST)
    testImplementation(Dependencies.Libs.AndroidTest.KOTLINX_COROUTINES_TEST)
    androidTestImplementation (Dependencies.Libs.AndroidTest.COMPOSE_UI_TEST)
    debugImplementation (Dependencies.Libs.AndroidTest.COMPOSE_UI_TEST_MANIFEST)
    androidTestImplementation (Dependencies.Libs.AndroidTest.COMPOSE_UI_TEST_NAVIGATION_TESTING)
}