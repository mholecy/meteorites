object Dependencies {
    const val gradlePlugin = "com.android.tools.build:gradle:${Versions.gradle}"

    object Plugins {
        const val detekt = "io.gitlab.arturbosch.detekt"
        const val ktlint = "org.jlleitschuh.gradle.ktlint"
        const val dependencyUpdates = "com.github.ben-manes.versions"
        const val googleMaps = "com.google.android.gms:play-services-maps:${Versions.maps}"
    }

    object Kotlin {
        const val gradlePlugin = "gradle-plugin"
        const val stdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.3.31"
    }

    object Support {
        const val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
        const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
        const val lifecycleExtensions = "androidx.lifecycle:lifecycle-extensions:${Versions.lifecycle}"
        const val material = "com.google.android.material:material:${Versions.material}"
        const val recyclerview = "androidx.recyclerview:recyclerview:${Versions.recyclerView}"
        const val pagingLibrary = "androidx.paging:paging-runtime:${Versions.pagingLibrary}"
        const val workManager = "androidx.work:work-runtime-ktx:${Versions.workManager}"
    }

    object DependencyInjection {
        const val daggerAndroid = "com.google.dagger:dagger-android:${Versions.dagger}"
        const val daggerAndroidSupport = "com.google.dagger:dagger-android-support:${Versions.dagger}"
        const val daggerCompiler = "com.google.dagger:dagger-compiler:${Versions.dagger}"
        const val daggerAndroidProcessor = "com.google.dagger:dagger-android-processor:${Versions.dagger}"
    }

    object Coroutines {
        const val coroutinesAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
    }

    object NavigationComponents {
        const val safeArgs = "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.navigationComponents}"
        const val fragment = "androidx.navigation:navigation-fragment-ktx:${Versions.navigationComponents}"
        const val ui = "androidx.navigation:navigation-ui-ktx:${Versions.navigationComponents}"
    }

    object Networking {
        const val moshi = "com.squareup.moshi:moshi:${Versions.moshi}"
        const val okHttp = "com.squareup.okhttp3:okhttp:${Versions.okhttp}"
        const val logging = "com.squareup.okhttp3:logging-interceptor:${Versions.okhttp}"
        const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
        const val retrofitConverter = "com.squareup.retrofit2:converter-moshi:${Versions.retrofit}"
    }

    object Database {
        const val room = "androidx.room:room-runtime:${Versions.room}"
        const val roomCompiler = "androidx.room:room-compiler:${Versions.room}"
    }

    object Other {
        const val timber = "com.jakewharton.timber:timber:${Versions.timber}"
    }

    object AndroidTests {
        const val androidJUnit = "androidx.test.ext:junit:${Versions.androidJUnit}"
        const val espresso = "androidx.test.espresso:espresso-core:${Versions.espresso}"
        const val runner = "androidx.test:runner:${Versions.androidxTest}"
    }
}
