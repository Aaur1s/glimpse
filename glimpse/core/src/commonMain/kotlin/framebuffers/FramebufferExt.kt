/*
 * Copyright 2020-2021 Slawomir Czerwinski
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

package graphics.glimpse.framebuffers

import graphics.glimpse.GlimpseAdapter

/**
 * Runs [block] of instructions with given [framebuffer] bound.
 *
 * @since v1.1.0
 */
inline fun GlimpseAdapter.withFramebuffer(
    framebuffer: Framebuffer,
    crossinline block: GlimpseAdapter.() -> Unit
) {
    glBindFramebuffer(framebuffer.handle)
    block()
    glBindFramebuffer(framebufferHandle = 0)
}
