plugins {
    id("com.android.library")
    kotlin("multiplatform")
    id("io.gitlab.arturbosch.detekt") version "1.14.2"
    `maven-publish`
}

repositories {
    google()
}

kotlin {
    android {
        publishLibraryVariants("release")
    }

    jvm(name = "desktop") {
        compilations.all {
            kotlinOptions.jvmTarget = "11"
        }
    }

    sourceSets {
        val commonMain by getting
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test-common"))
                implementation(kotlin("test-annotations-common"))
            }
        }
        val androidMain by getting
        val androidTest by getting {
            dependencies {
                implementation("junit:junit:4.13.1")
            }
        }
        val desktopMain by getting
        val desktopTest by getting {
            dependencies {
                implementation(kotlin("test-junit"))
            }
        }
    }
}

detekt {
    input = files(kotlin.sourceSets.flatMap { it.kotlin.sourceDirectories })
    config = files(".config/detekt.yml")
    buildUponDefaultConfig = true
    reports {
        xml {
            enabled = true
            destination = file("$buildDir/reports/detekt.xml")
        }
        html {
            enabled = true
            destination = file("$buildDir/reports/detekt.html")
        }
    }
}

android {
    compileSdkVersion(apiLevel = 30)
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig {
        minSdkVersion(24)
        targetSdkVersion(30)
    }
}

publishing {
    publications {
        afterEvaluate {
            filterIsInstance<MavenPublication>().forEach { publication ->
                publication.artifactId = "${project.parent?.name}-${publication.artifactId}"
                publication.pom {
                    name.set("Glimpse ${project.name.capitalize()}")
                    description.set("OpenGL made simple")
                    url.set("https://glimpse.graphics/")
                    scm {
                        connection.set("scm:git:https://github.com/glimpse-graphics/glimpse.git")
                        developerConnection.set("scm:git:https://github.com/glimpse-graphics/glimpse.git")
                        url.set("https://github.com/glimpse-graphics/glimpse")
                    }
                    licenses {
                        license {
                            name.set("The Apache Software License, Version 2.0")
                            url.set("http://www.apache.org/licenses/LICENSE-2.0")
                        }
                    }
                    developers {
                        developer {
                            id.set("sczerwinski")
                            name.set("Slawomir Czerwinski")
                            email.set("slawomir@czerwinski.it")
                            url.set("https://czerwinski.it/")
                        }
                    }
                    issueManagement {
                        system.set("GitHub Issues")
                        url.set("https://github.com/glimpse-graphics/glimpse/issues")
                    }
                    ciManagement {
                        system.set("GitHub Actions")
                        url.set("https://github.com/glimpse-graphics/glimpse/actions")
                    }
                }
            }
        }

        repositories {
            maven {
                url = uri("$buildDir/maven")
            }
        }
    }
}
