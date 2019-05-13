plugins {
    id("com.android.application")
    id("androidx.navigation.safeargs")
    kotlin("android")
    kotlin("kapt")
    kotlin("android.extensions")
}

android {
    compileSdkVersion(Project.targetSdk)
    defaultConfig {
        applicationId = Project.applicationId
        minSdkVersion(Project.minSdk)
        targetSdkVersion(Project.targetSdk)
        versionCode = Project.versionCode
        versionName = Project.versionName
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        vectorDrawables.useSupportLibrary = true
        multiDexEnabled = true
    }

    androidExtensions {
        configure {
            isExperimental = true
        }
    }

    packagingOptions {
        exclude("META-INF/DEPENDENCIES")
        exclude("META-INF/DEPENDENCIES")
        exclude("META-INF/LICENSE")
        exclude("README.txt")
    }

    dataBinding {
        isEnabled = true
    }

    compileOptions {
        setSourceCompatibility(JavaVersion.VERSION_1_8)
        setTargetCompatibility(JavaVersion.VERSION_1_8)
    }

    signingConfigs {
        getByName(Project.BuildType.DEBUG) {
            storeFile = rootProject.file("./keystore/debug.jks")
            storePassword = Project.Debug.STORE_PASSWORD
            keyAlias = Project.Debug.KEY_ALIAS
            keyPassword = Project.Debug.KEY_PASSWORD
        }
        create(Project.BuildType.RELEASE) {
            storeFile = rootProject.file("./keystore/client.jks")
            storePassword = Project.Debug.STORE_PASSWORD
            keyAlias = Project.Debug.KEY_ALIAS
            keyPassword = Project.Debug.KEY_PASSWORD
        }
    }

    sourceSets {
        getByName("main").java.setSrcDirs(hashSetOf("src/main/kotlin"))
        create(Project.Flavor.DEVELOP).java.setSrcDirs(hashSetOf("src/dev/kotlin"))
        create(Project.Flavor.PRODUCTION).java.setSrcDirs(hashSetOf("src/prod/kotlin"))
        getByName("test").java.setSrcDirs(hashSetOf("src/test/kotlin"))
        getByName("androidTest").java.setSrcDirs(hashSetOf("src/androidTest/kotlin"))
    }

    buildTypes {
        getByName(Project.BuildType.DEBUG) {
            manifestPlaceholders = mapOf("enableCrashReporting" to "false")
            isMinifyEnabled = false
            isShrinkResources = false
            signingConfig = signingConfigs.getByName(Project.BuildType.DEBUG)
        }
        getByName(Project.BuildType.RELEASE) {
            manifestPlaceholders = mapOf("enableCrashReporting" to "true")
            isMinifyEnabled = true
            isShrinkResources = true
            signingConfig = signingConfigs.getByName(Project.BuildType.RELEASE)
            proguardFile(getDefaultProguardFile("proguard-android-optimize.txt"))
            proguardFile(file("proguard-rules.pro"))
        }
    }

    flavorDimensions(Project.Flavor.DIMENSION)
    productFlavors {
        create(Project.Flavor.DEVELOP) {
            setDimension(Project.Flavor.DIMENSION)
        }
        create(Project.Flavor.PRODUCTION) {
            setDimension(Project.Flavor.DIMENSION)
        }
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(Dependencies.Kotlin.stdlib)
    implementation(Dependencies.Coroutines.coroutinesAndroid)

    implementation(Dependencies.NavigationComponents.fragment)
    implementation(Dependencies.NavigationComponents.ui)

    implementation(Dependencies.Support.lifecycleExtensions)
    implementation(Dependencies.Support.appcompat)
    implementation(Dependencies.Support.constraintLayout)
    implementation(Dependencies.Support.pagingLibrary)
    implementation(Dependencies.Support.recyclerview)
    implementation(Dependencies.Support.material)
    implementation(Dependencies.Support.workManager)

    implementation(Dependencies.Database.room)

    implementation(Dependencies.Networking.moshi)
    implementation(Dependencies.Networking.okHttp)
    implementation(Dependencies.Networking.logging)
    implementation(Dependencies.Networking.retrofit)
    implementation(Dependencies.Networking.retrofitConverter)

    implementation(Dependencies.Plugins.googleMaps)

    implementation(Dependencies.Other.timber)

    implementation(Dependencies.DependencyInjection.daggerAndroid)
    implementation(Dependencies.DependencyInjection.daggerAndroidSupport)

    kapt(Dependencies.DependencyInjection.daggerAndroidProcessor)
    kapt(Dependencies.DependencyInjection.daggerCompiler)
    kapt(Dependencies.Database.roomCompiler)

    androidTestImplementation(Dependencies.AndroidTests.androidJUnit)
    androidTestImplementation(Dependencies.AndroidTests.espresso)
    androidTestImplementation(Dependencies.AndroidTests.runner)
}
