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

package graphics.glimpse.ui.compose.types

import androidx.compose.ui.graphics.Color
import graphics.glimpse.types.Vec3
import graphics.glimpse.types.Vec4

/**
 * Returns a [Vec3] representation of a given [color].
 *
 * @deprecated Use [toVec3] instead.
 *
 * @since v1.1.0
 */
@Suppress("FunctionNaming")
@Deprecated(
    message = "Use Color.toVec3() instead",
    replaceWith = ReplaceWith("color.toVec3()", "graphics.glimpse.ui.compose.types.toVec3")
)
fun Vec3(color: Color): Vec3<Float> {
    return Vec3(color.red, color.green, color.blue)
}

/**
 * Returns a [Vec4] representation of a given [color].
 *
 * @deprecated Use [toVec4] instead.
 *
 * @since v1.1.0
 */
@Suppress("FunctionNaming")
@Deprecated(
    message = "Use Color.toVec4() instead",
    replaceWith = ReplaceWith("color.toVec4()", "graphics.glimpse.ui.compose.types.toVec4")
)
fun Vec4(color: Color): Vec4<Float> {
    return Vec4(color.red, color.green, color.blue, color.alpha)
}

/**
 * Returns a [Vec3] representation of this [Color].
 *
 * @since v2.0.0
 */
fun Color.toVec3(): Vec3<Float> =
    Vec3(x = this.red, y = this.green, z = this.blue)

/**
 * Returns a [Vec4] representation of this [Color].
 *
 * @since v2.0.0
 */
fun Color.toVec4(): Vec4<Float> =
    Vec4(x = this.red, y = this.green, z = this.blue, w = this.alpha)

/**
 * Returns a Compose [Color] representation of this [Vec3].
 *
 * @since v2.0.0
 */
fun Vec3<Float>.toComposeColor(): Color =
    Color(red = this.r, green = this.g, blue = this.b)

/**
 * Returns a Compose [Color] representation of this [Vec4].
 *
 * @since v2.0.0
 */
fun Vec4<Float>.toComposeColor(): Color =
    Color(red = this.r, green = this.g, blue = this.b, alpha = this.a)
