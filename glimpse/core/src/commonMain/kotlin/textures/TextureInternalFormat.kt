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

package graphics.glimpse.textures

/**
 * Texture color components.
 *
 * @since v1.1.0
 */
enum class TextureInternalFormat {

    /**
     * Only depth component.
     */
    DEPTH_COMPONENT,

    /**
     * Depth and stencil pairs.
     *
     * @since v2.0.0
     */
    DEPTH_STENCIL,

    /**
     * Only red component.
     *
     * @since v2.0.0
     */
    RED,

    /**
     * Red/green pair color.
     *
     * @since v2.0.0
     */
    RG,

    /**
     * RGB color.
     */
    RGB,

    /**
     * RGBA color.
     */
    RGBA,

    /**
     * RGB color (16-bit float per channel).
     */
    RGB16F,

    /**
     * RGBA color (16-bit float per channel).
     */
    RGBA16F,

    /**
     * RGB color (32-bit float per channel).
     *
     * @since v2.0.0
     */
    RGB32F,

    /**
     * RGBA color (32-bit float per channel).
     *
     * @since v2.0.0
     */
    RGBA32F
}
