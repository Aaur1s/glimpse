buildscript {
    repositories {
        gradlePluginPortal()
        jcenter()
        google()
        mavenCentral()
    }
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.4.21")
        classpath("com.android.tools.build:gradle:4.0.2")
    }
}

allprojects {

    val glimpseGroupId: String by project
    val glimpseVersion: String by project

    group = glimpseGroupId
    version = glimpseVersion

    repositories {
        jcenter()
        mavenCentral()
    }
}

plugins {
    id("org.jetbrains.changelog") version "0.6.2"
}
