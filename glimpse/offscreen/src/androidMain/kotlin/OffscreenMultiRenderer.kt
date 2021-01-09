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

package graphics.glimpse.offscreen

import graphics.glimpse.GlimpseAdapter
import graphics.glimpse.PixelFormat

/**
 * Offscreen multi-renderer. Implement this class to render multiple images without displaying
 * them on screen.
 */
actual abstract class OffscreenMultiRenderer(gl: GlimpseAdapter) : OffscreenRenderer(gl) {

    /**
     * Implement this property to define number of images to render.
     */
    protected actual abstract val imagesCount: Int

    /**
     * Render all images in a loop.
     */
    actual final override fun doRender(gl: GlimpseAdapter) {
        onCreate(gl)
        gl.glViewport(x = 0, y = 0, width = width, height = height)
        renderImages(gl)
        onDestroy(gl)
    }

    private fun renderImages(gl: GlimpseAdapter) {
        for (index in 0 until imagesCount) {
            onRender(gl, index)
            onImage(readPixels(format = PixelFormat.RGBA), index)
        }
    }

    /**
     * Implement this method to initialize [OpenGL adapter][gl] before rendering first image.
     */
    protected actual abstract fun onCreate(gl: GlimpseAdapter)

    /**
     * Implement this method to render an image at a given [index].
     */
    protected actual abstract fun onRender(gl: GlimpseAdapter, index: Int)

    /**
     * Implement this method to process image [pixels] at a given [index].
     */
    protected actual abstract fun onImage(pixels: ByteArray, index: Int)

    /**
     * Implement this method to dispose [OpenGL adapter][gl] after rendering last image.
     */
    protected actual abstract fun onDestroy(gl: GlimpseAdapter)
}
