object Dependencies {
    object Libs {

        object Compose{
            const val COMPOSE_MATERIAL = "androidx.compose.material:material:${Versions.COMPOSE}"
            const val COMPOSE_TOOLING = "androidx.compose.ui:ui-tooling-preview-android:${Versions.COMPOSE_TOOLING}"
        }

        object Retrofit {
            const val RETROFIT2_CONVERTER =
                "com.squareup.retrofit2:converter-gson:${Versions.RETROFIT2}"
            const val RETROFIT2 = "com.squareup.retrofit2:retrofit:${Versions.RETROFIT2}"
        }

        object Koin {
            const val KOIN_CORE = "io.insert-koin:koin-core:${Versions.KOIN}"
            const val KOIN_ANDROID = "io.insert-koin:koin-android:${Versions.KOIN}"
            const val KOIN_ANDROIDX_COMPOSE =
                "io.insert-koin:koin-androidx-compose:${Versions.KOIN}"


            const val KOIN_ANNOTATIONS =
                "io.insert-koin:koin-annotations:${Versions.KOIN_KSP_VERSION}"
            const val KOIN_KSP = "io.insert-koin:koin-ksp-compiler:${Versions.KOIN_KSP_VERSION}"
        }

        object Android {
            const val ANDROIDX_CORE = "androidx.core:core-ktx:${Versions.ANDROIDX_CORE}"
            const val ANDROIDX_APPCOMPAT =
                "androidx.appcompat:appcompat:${Versions.ANDROIDX_APPCOMPAT}"
            const val ANDROID_MATERIAL =
                "com.google.android.material:material:${Versions.ANDROID_MATERIAL}"
        }

        object AndroidTest {
            const val JUNIT = "junit:junit:${Versions.JUNIT}"
            const val ANDROIDX_TEST_EXT = "androidx.test.ext:junit:${Versions.ANDROIDX_TEST_EXT}"
            const val TEST_ESPRESSO =
                "androidx.test.espresso:espresso-core:${Versions.TEST_ESPRESSO}"
            const val MOCKK = "io.mockk:mockk:${Versions.MOCKK}"
            const val ROBOLECTRIC = "org.robolectric:robolectric:${Versions.ROBOLECTRIC}"
            const val KOIN_TEST = "io.insert-koin:koin-test:${Versions.KOIN}"
            const val KOTLINX_COROUTINES_TEST = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.KOTLINX_COROUTINES_TEST}"
            const val COMPOSE_UI_TEST = "androidx.compose.ui:ui-test-junit4:${Versions.COMPOSE_UI_TEST}"
            const val COMPOSE_UI_TEST_NAVIGATION_TESTING = "androidx.navigation:navigation-testing:${Versions.COMPOSE_UI_TEST_NAVIGATION_TESTING}"
            const val COMPOSE_UI_TEST_MANIFEST = "androidx.compose.ui:ui-test-manifest:${Versions.COMPOSE_UI_TEST_MANIFEST}"
        }
    }
}