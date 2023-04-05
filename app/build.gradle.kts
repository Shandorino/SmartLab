plugins {
    id ("com.android.application")
    id ("org.jetbrains.kotlin.android")
    id ("com.google.devtools.ksp") version "1.8.10-1.0.9"
}

android {
    namespace = "com.example.smartlab"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.example.smartlab"
        minSdk = 29
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
            proguardFiles (getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
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
        kotlinCompilerExtensionVersion = "1.4.4"
    }
    packagingOptions {
        resources {
            excludes.add("/META-INF/{AL2.0,LGPL2.1}")
        }
    }
}

dependencies {

    val composeVersion =
        rootProject.extra.get("compose_ui_version") as String

    implementation ("androidx.core:core-ktx:1.9.0")
    implementation ("androidx.lifecycle:lifecycle-runtime-ktx:2.6.1")
    implementation ("androidx.activity:activity-compose:1.7.0")
    implementation ("androidx.compose.ui:ui:$composeVersion")
    implementation ("androidx.compose.ui:ui-tooling-preview:$composeVersion")
    implementation ("androidx.compose.material:material:1.4.0")
    testImplementation ("junit:junit:4.13.2")
    androidTestImplementation ("androidx.test.ext:junit:1.1.5")
    androidTestImplementation ("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation ("androidx.compose.ui:ui-test-junit4:$composeVersion")
    debugImplementation ("androidx.compose.ui:ui-tooling:$composeVersion")
    debugImplementation ("androidx.compose.ui:ui-test-manifest:$composeVersion")


    val voyagerVersion = "1.0.0-rc04"
    implementation("cafe.adriel.voyager:voyager-navigator:$voyagerVersion")
    implementation("cafe.adriel.voyager:voyager-androidx:$voyagerVersion")
    implementation("cafe.adriel.voyager:voyager-koin:$voyagerVersion")

    //ksp
    val kotlin_version = "1.8.10"

    implementation("com.google.devtools.ksp:symbol-processing-api:1.8.10-1.0.9")
    implementation("org.jetbrains.kotlin:kotlin-stdlib:$kotlin_version")

    //ktor
    val ktor_version = "2.2.4"

    implementation("io.ktor:ktor-client-core:$ktor_version")
    implementation("io.ktor:ktor-client-android:$ktor_version")
    implementation("io.ktor:ktor-serialization-gson:$ktor_version")
    implementation("io.ktor:ktor-client-content-negotiation:$ktor_version")

//    //gson
//    implementation ("com.google.code.gson:gson:2.10.1")

    //koin
    val koin_version = "3.3.3"

    ksp("io.insert-koin:koin-core:$koin_version")

    implementation("io.insert-koin:koin-android:$koin_version")
    implementation("io.insert-koin:koin-androidx-compose:3.4.2")

    val koin_ksp_version = "1.1.1"

    implementation("io.insert-koin:koin-annotations:$koin_ksp_version")
    ksp("io.insert-koin:koin-ksp-compiler:$koin_ksp_version")

    //room
    val room_version = "2.5.1"

    implementation("androidx.room:room-runtime:$room_version")
    ksp("androidx.room:room-compiler:$room_version")

    ksp("androidx.room:room-compiler:$room_version")

    implementation("androidx.room:room-ktx:$room_version")
}