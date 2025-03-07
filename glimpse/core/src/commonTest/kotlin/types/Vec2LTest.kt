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

package graphics.glimpse.types

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.assertSame

class Vec2LTest {

    @Test
    fun `GIVEN a vector, WHEN u, THEN return x`() {
        val vector = Vec2(x = 7L, y = 13L)

        val result = vector.u

        assertEquals(7L, result)
    }

    @Test
    fun `GIVEN a vector, WHEN v, THEN return y`() {
        val vector = Vec2(x = 7L, y = 13L)

        val result = vector.v

        assertEquals(13L, result)
    }

    @Test
    fun `GIVEN a vector, WHEN unaryPlus, THEN return the same vector`() {
        val vector = Vec2(x = 7L, y = 13L)

        val result = +vector

        assertSame(vector, result)
    }

    @Test
    fun `GIVEN a vector, WHEN unaryMinus, THEN return the opposite vector`() {
        val vector = Vec2(x = 7L, y = 13L)

        val result = -vector

        assertEquals(Vec2(x = -7L, y = -13L), result)
    }

    @Test
    fun `GIVEN two vectors, WHEN plus, THEN return sum of two vectors`() {
        val v1 = Vec2(x = 10L, y = 20L)
        val v2 = Vec2(x = 1L, y = 2L)

        val result = v1 + v2

        assertEquals(Vec2(x = 11L, y = 22L), result)
    }

    @Test
    fun `GIVEN two vectors, WHEN minus, THEN return difference of two vectors`() {
        val v1 = Vec2(x = 10L, y = 20L)
        val v2 = Vec2(x = 1L, y = 2L)

        val result = v1 - v2

        assertEquals(Vec2(x = 9L, y = 18L), result)
    }

    @Test
    fun `GIVEN a vector and a number, WHEN times, THEN return product of the vector and the number`() {
        val vector = Vec2(x = 1L, y = 2L)
        val number = 3L

        val result = vector * number

        assertEquals(Vec2(x = 3L, y = 6L), result)
    }

    @Test
    fun `GIVEN a vector and a number, WHEN div, THEN return quotient of the vector and the number`() {
        val vector = Vec2(x = 5L, y = 7L)
        val number = 2L

        val result = vector / number

        assertEquals(Vec2(x = 2L, y = 3L), result)
    }

    @Test
    fun `GIVEN two vectors, WHEN dot, THEN return dot product of two vectors`() {
        val v1 = Vec2(x = 10L, y = 20L)
        val v2 = Vec2(x = 1L, y = 2L)

        val result = v1 dot v2

        assertEquals(50L, result)
    }

    @Test
    fun `GIVEN two vectors, WHEN cross, THEN return cross product of two vectors`() {
        val v1 = Vec2(x = 1L, y = 2L)
        val v2 = Vec2(x = 3L, y = 2L)

        val result = v1 cross v2

        assertEquals(Vec3(x = 0L, y = 0L, z = -4L), result)
    }

    @Test
    fun `GIVEN a vector, WHEN atan, THEN return arc tangent of the vector`() {
        val vector = Vec2(x = 1L, y = 1L)

        assertFailsWith<UnsupportedOperationException> {
            vector.atan()
        }
    }

    @Test
    fun `GIVEN a vector, WHEN magnitude, THEN return vector's magnitude`() {
        val vector = Vec2(x = 3L, y = 4L)

        assertFailsWith<UnsupportedOperationException> {
            vector.magnitude()
        }
    }

    @Test
    fun `GIVEN a vector, WHEN normalize, THEN return a unit vector in the same direction`() {
        val vector = Vec2(x = 3L, y = 4L)

        assertFailsWith<UnsupportedOperationException> {
            vector.normalize()
        }
    }

    @Test
    fun `GIVEN a vector, WHEN toVec3, THEN return the a 3D vector with z = 0`() {
        val vector = Vec2(x = 7L, y = 13L)

        val result = vector.toVec3()

        assertEquals(Vec3(x = 7L, y = 13L, z = 0L), result)
    }

    @Test
    fun `GIVEN a vector, WHEN toVec3 with z, THEN return the a 3D vector with z`() {
        val vector = Vec2(x = 7L, y = 13L)

        val result = vector.toVec3(z = 29L)

        assertEquals(Vec3(x = 7L, y = 13L, z = 29L), result)
    }

    @Test
    fun `GIVEN a vector, WHEN toVec4, THEN return the a 4D vector with z = 0 and w = 0`() {
        val vector = Vec2(x = 7L, y = 13L)

        val result = vector.toVec4()

        assertEquals(Vec4(x = 7L, y = 13L, z = 0L, w = 0L), result)
    }

    @Test
    fun `GIVEN a vector, WHEN toVec4 with z and w, THEN return the a 4D vector with z and w`() {
        val vector = Vec2(x = 7L, y = 13L)

        val result = vector.toVec4(z = 29L, w = 31L)

        assertEquals(Vec4(x = 7L, y = 13L, z = 29L, w = 31L), result)
    }

    @Test
    fun `GIVEN a vector, WHEN toList, THEN return vector's coordinates as list`() {
        val vector = Vec2(x = 10L, y = 20L)

        val result = vector.toList()

        assertEquals(listOf(10L, 20L), result)
    }

    @Test
    fun `GIVEN a vector, WHEN toLongArray, THEN return vector's coordinates as array`() {
        val vector = Vec2(x = 10L, y = 20L)

        val result = vector.toLongArray()

        assertEquals(listOf(10L, 20L), result.toList())
    }

    @Test
    fun `GIVEN a list, WHEN fromList, THEN return vector with coordinates from list`() {
        val list = listOf(1L, 2L)

        val result = Vec2.fromList(list)

        assertEquals(Vec2(x = 1L, y = 2L), result)
    }

    @Test
    fun `GIVEN a list of 3 numbers, WHEN fromList, THEN throw exception`() {
        val list = listOf(1L, 2L, 3L)

        assertFailsWith<IllegalArgumentException> {
            Vec2.fromList(list)
        }
    }
}
