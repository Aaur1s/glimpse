/*
 * Copyright 2020 Slawomir Czerwinski
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package graphics.glimpse.meshes.obj

import android.content.Context
import graphics.glimpse.meshes.MeshData
import java.io.File
import java.io.InputStream

/**
 * Returns a container for the array buffers data related to a single mesh loaded from a
 * Wavefront OBJ input.
 */
fun ObjMeshDataParser.parseArrayMeshData(inputStream: InputStream): MeshData =
    inputStream
        .use { input -> input.bufferedReader().readLines() }
        .let { lines -> parseArrayMeshData(lines) }

/**
 * Returns a container for the array buffers data related to a single mesh loaded from a
 * Wavefront OBJ file.
 */
fun ObjMeshDataParser.parseArrayMeshData(file: File): MeshData =
    parseArrayMeshData(file.inputStream())

/**
 * Returns a container for the array buffers data related to a single mesh loaded from a
 * Wavefront OBJ asset.
 */
fun ObjMeshDataParser.parseArrayMeshData(context: Context, fileName: String): MeshData =
    parseArrayMeshData(context.assets.open(fileName))

/**
 * Returns a container for the array buffers data related to a single mesh loaded from a
 * Wavefront OBJ raw resource.
 */
fun ObjMeshDataParser.parseArrayMeshData(context: Context, resId: Int): MeshData =
    parseArrayMeshData(context.resources.openRawResource(resId))
