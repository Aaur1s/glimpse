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

import org.jetbrains.dokka.gradle.DokkaTaskPartial

plugins {
    id("org.jetbrains.dokka")
}

tasks {

    dokkaHtml {
        moduleName.set("${project.parent?.name}-${project.name}")
        outputDirectory.set(project.layout.buildDirectory.dir("javadoc").get().asFile)
        dokkaSourceSets {
            configureEach {
                includes.from(project.files("module.md", "packages.md"))
                samples.from(project.fileTree("src/samples/kotlin").files)
            }
        }
    }

    named<DokkaTaskPartial>("dokkaHtmlPartial") {
        moduleName.set("${project.parent?.name}-${project.name}")
        dokkaSourceSets {
            configureEach {
                includes.from(project.files("module.md", "packages.md"))
                samples.from(project.fileTree("src/samples/kotlin").files)
            }
        }
    }
}
