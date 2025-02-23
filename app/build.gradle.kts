import com.lobito.buildsrc.Deps
import java.util.Properties

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.jetbrainsKotlinSerialization)
    alias(libs.plugins.kotlin.parcelize)
//    alias(libs.plugins.kotlin.kapt)
    alias(libs.plugins.ksp.module.plugin)
//    id("com.google.devtools.ksp")
}

configurations.all {
    exclude(group = "com.intellij", module = "annotations")
    exclude(group = "org.json", module = "json")
}


android {
    namespace = "com.lobito.appbusesvip"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.lobito.appbusesvip"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0.0"

        val properties = Properties().apply {
            load(rootProject.file("local.properties").inputStream())
        }

        buildConfigField("String", "API_SEGURIDAD_DEV", "\"${properties.getProperty("API_SEGURIDAD_DEV")}\"")
        buildConfigField("String", "API_SEGURIDAD_PROD", "\"${properties.getProperty("API_SEGURIDAD_PROD")}\"")
        buildConfigField("String", "API_BUSES_DEV", "\"${properties.getProperty("API_BUSES_DEV")}\"")
        buildConfigField("String", "API_BUSES_PROD", "\"${properties.getProperty("API_BUSES_PROD")}\"")
        buildConfigField("String", "API_EMPLOYEE_PROD", "\"${properties.getProperty("API_EMPLOYEE_PROD")}\"")
        buildConfigField("String", "API_INVENTARIO_PROD", "\"${properties.getProperty("API_INVENTARIO_PROD")}\"")
        buildConfigField("String", "USER_TOKEN_BUSES", "\"${properties.getProperty("USER_TOKEN_BUSES")}\"")
        buildConfigField("String", "PASSWORD_TOKEN_BUSES", "\"${properties.getProperty("PASSWORD_TOKEN_BUSES")}\"")
        buildConfigField("String", "USER_TOKEN_EMPLOYEE", "\"${properties.getProperty("USER_TOKEN_EMPLOYEE")}\"")
        buildConfigField("String", "PASSWORD_TOKEN_EMPLOYEE", "\"${properties.getProperty("PASSWORD_TOKEN_EMPLOYEE")}\"")

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

    }


    buildTypes {
        debug {
           isMinifyEnabled = false
           proguardFiles(
               getDefaultProguardFile("proguard-android-optimize.txt"),
               "proguard-rules.pro"
           )
           Deps.endpointsGlobal.forEach {
               buildConfigField("String", it.first, it.second)
           }

        }
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            Deps.endpointsGlobal.forEach {
                buildConfigField("String", it.first, it.second)
            }
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
        buildConfig = true
    }
}

dependencies {

    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar", "*.aar"))))
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    // Navigation Compose
    implementation(libs.androidx.navigation.compose)
    implementation(libs.kotlinx.serialization.json)

//    //use koin
    implementation(libs.koin.androidx.compose)

    // Retrofit Core
    implementation(libs.okhttp.logging)
    implementation(libs.coroutines.core)
    implementation(libs.retrofit2.retrofit)
    implementation(libs.converter.gson)

//    // ROOM Database
    implementation(libs.androidx.room.runtime)
    implementation(libs.androidx.room.ktx)
    ksp(libs.androidx.room.compiler)

//    // Lottie
    implementation(libs.lottie.compose)

//    // QR
    implementation(libs.zxing)

    // LIVEDATA
    implementation(libs.compose.runtime.livedata)
    implementation(libs.androidx.compose.lifecycle)

    //Work Manager
    implementation(libs.workmanager)
    implementation(libs.workmanager.koin)

    //Data Store
    implementation(libs.datastore)
}