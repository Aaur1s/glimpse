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

package graphics.glimpse.testing

import graphics.glimpse.geom.Polygon
import graphics.glimpse.testing.internal.messagePrefix

/**
 * Asserts that the [actual] value is equal to the [expected] value plus/minus [delta],
 * with an optional [message].
 *
 * @since v2.0.0
 */
@JvmName("assertFloatPolygonEqualsWithDelta")
fun assertEqualsWithDelta(
    expected: Polygon<Float>,
    actual: Polygon<Float>,
    delta: Delta = Delta.MEDIUM,
    message: String? = null
) {
    val messagePrefix = messagePrefix(message)
    assertEqualsWithDelta(
        expected = expected.vertices,
        actual = actual.vertices,
        delta = delta,
        message = "${messagePrefix}Polygon vertices are different"
    )
}

/**
 * Asserts that the [actual] value is equal to the [expected] value plus/minus [delta],
 * with an optional [message].
 *
 * @since v2.0.0
 */
@JvmName("assertDoublePolygonEqualsWithDelta")
fun assertEqualsWithDelta(
    expected: Polygon<Double>,
    actual: Polygon<Double>,
    delta: Delta = Delta.MEDIUM,
    message: String? = null
) {
    val messagePrefix = messagePrefix(message)
    assertEqualsWithDelta(
        expected = expected.vertices,
        actual = actual.vertices,
        delta = delta,
        message = "${messagePrefix}Polygon vertices are different"
    )
}
