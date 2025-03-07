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

package graphics.glimpse.hud

import graphics.glimpse.textures.Texture
import graphics.glimpse.types.Mat4

/**
 * Interface for most atomic part of HUD.
 *
 * The [texture] of each atom will be displayed as a 1×1 square,
 * transformed using its [modelMatrix].
 */
interface HudAtom {

    /**
     * Texture of this atom.
     */
    val texture: Texture

    /**
     * Intrinsic width of this atom.
     */
    val intrinsicWidth: Float get() = texture.width.toFloat()

    /**
     * Intrinsic height of this atom.
     */
    val intrinsicHeight: Float get() = texture.height.toFloat()

    /**
     * Model matrix of this atom.
     */
    val modelMatrix: Mat4<Float>
}
