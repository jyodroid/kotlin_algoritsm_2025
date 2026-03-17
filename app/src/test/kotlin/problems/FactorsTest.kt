package problems

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FactorsTest {

    @Test
    fun `test greatestCommonDivisor with array 24, 36`() {
        val numbers = arrayOf(24, 36)
        val result = greatestCommonDivisor(numbers)
        assertEquals(12, result)
    }

    @Test
    fun `test greatestCommonDivisor with multiple numbers`() {
        val numbers = arrayOf(8, 12, 16)
        val result = greatestCommonDivisor(numbers)
        assertEquals(4, result)
    }

    @Test
    fun `test greatestCommonDivisor with primes`() {
        val numbers = arrayOf(7, 13)
        val result = greatestCommonDivisor(numbers)
        assertEquals(1, result)
    }

    @Test
    fun `test leastCommonMultiple with array 24, 36`() {
        val numbers = arrayOf(24, 36)
        val result = leastCommonMultiple(numbers)
        assertEquals(72, result)
    }

    @Test
    fun `test leastCommonMultiple with multiple numbers`() {
        val numbers = arrayOf(3, 4, 6)
        val result = leastCommonMultiple(numbers)
        assertEquals(12, result)
    }

    @Test
    fun `test bridge with array a 2, 4 and b 16, 32, 96`() {
        val a = arrayOf(2, 4)
        val b = arrayOf(16, 32, 96)
        val result = bridge(a, b)
        assertEquals(3, result)
    }
}
