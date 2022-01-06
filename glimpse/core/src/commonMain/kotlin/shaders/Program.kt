/*
 * Copyright 2020-2022 Slawomir Czerwinski
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
 */

package graphics.glimpse.shaders

import graphics.glimpse.GlimpseAdapter

/**
 * A program.
 */
interface Program {

    /**
     * Program handle.
     */
    val handle: Int

    /**
     * Tells the given [OpenGL adapter][gl] to use this program.
     */
    fun use(gl: GlimpseAdapter)

    /**
     * Tells the given [OpenGL adapter][gl] to dispose this program.
     */
    fun dispose(gl: GlimpseAdapter)

    /**
     * A builder for programs.
     */
    interface Builder {

        /**
         * Will attach [vertexShader] when building a program.
         */
        fun withVertexShader(vertexShader: Shader): Builder

        /**
         * Will attach [fragmentShader] when building a program.
         */
        fun withFragmentShader(fragmentShader: Shader): Builder

        /**
         * Builds a new program with previously configured shaders.
         */
        fun build(): Program

        companion object {

            /**
             * Returns a new instance of program builder.
             */
            fun newInstance(gl: GlimpseAdapter): Builder = ProgramBuilderImpl(gl)
        }
    }
}
