// Top-level build file where you can add configuration options common to all sub-projects/modules.

buildscript {
    repositories {
        google() // Google's Maven repository
        mavenCentral() // Maven Central repository
    }
    dependencies {
        classpath("com.android.tools.build:gradle:8.2.0") // Android Gradle Plugin

        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
        classpath("com.google.gms:google-services:4.3.15") // Google Services Gradle Plugin
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}
