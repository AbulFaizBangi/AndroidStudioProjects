
android {
    namespace = "com.example.acordertrackingapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.acordertrackingapp"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    buildFeatures {
        viewBinding = true // Keep if you want to use view binding
    }
}

dependencies {
    // AndroidX Core Libraries
    implementation(libs.appcompat) // use version catalog reference
    implementation(libs.core.ktx) // use version catalog reference
    implementation(libs.constraintlayout) // use version catalog reference

    // Testing Dependencies
    testImplementation(libs.junit) // use version catalog reference
    androidTestImplementation(libs.ext.junit) // use version catalog reference
    androidTestImplementation(libs.espresso.core) // use version catalog reference
}

// In your settings.gradle file, define the version catalog like this:
dependencyResolutionManagement {
    versionCatalogs {
        create("libs") {
            version("appcompat", "1.7.0")
            version("coreKtx", "1.13.1")
            version("constraintLayout", "2.1.4")
            version("junit", "4.13.2")
            version("extJunit", "1.2.1")
            version("espressoCore", "3.6.1")

            // Define aliases for the dependencies
            library("appcompat", "androidx.appcompat:appcompat").versionRef("appcompat")
            library("core.ktx", "androidx.core:core-ktx").versionRef("coreKtx")
            library("constraintlayout", "androidx.constraintlayout:constraintlayout").versionRef("constraintLayout")
            library("junit", "junit:junit").versionRef("junit")
            library("ext.junit", "androidx.test.ext:junit").versionRef("extJunit")
            library("espresso.core", "androidx.test.espresso:espresso-core").versionRef("espressoCore")
        }
    }
}
