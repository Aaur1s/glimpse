/*
 * Copyright 2020-2023 Glimpse Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package graphics.glimpse.internal

import org.jetbrains.kotlin.gradle.dsl.KotlinProjectExtension

plugins {
    id("io.gitlab.arturbosch.detekt")
}

afterEvaluate {

    val kotlin = extensions.getByName("kotlin") as KotlinProjectExtension

    detekt {
        source.setFrom(project.files(kotlin.sourceSets.flatMap { it.kotlin.sourceDirectories }))
        config.setFrom(project.files("${project.rootDir}/.config/detekt.yml"))
        buildUponDefaultConfig = true
    }

    tasks.detekt.configure {
        reports {
            xml {
                required.set(true)
                outputLocation.set(project.file("${project.layout.buildDirectory.get().asFile}/reports/detekt.xml"))
            }
            html {
                required.set(true)
                outputLocation.set(project.file("${project.layout.buildDirectory.get().asFile}/reports/detekt.html"))
            }
        }
    }

}
