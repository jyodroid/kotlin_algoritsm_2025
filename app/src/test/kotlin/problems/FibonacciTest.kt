package problems

import com.herrajeselpaisa.problems.fibonacciIterative
import com.herrajeselpaisa.problems.fibonacciMemoization
import com.herrajeselpaisa.problems.fibonacciRecursive
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class FibonacciTest {
    @Test
    fun `fibonacciRecursive should return n for n less than or equal to 2`() {
        assertEquals(0, fibonacciRecursive(0))
        assertEquals(1, fibonacciRecursive(1))
        assertEquals(1, fibonacciRecursive(2))
    }

    @Test
    fun `fibonacciRecursive should return sum of previous two numbers for n greater than 2`() {
        // f(3) = f(2) + f(1) = 1 + 1 = 2
        assertEquals(2, fibonacciRecursive(3))

        // f(4) = f(3) + f(2) = 2 + 1 = 3
        assertEquals(3, fibonacciRecursive(4))

        // f(5) = f(4) + f(3) = 3 + 2 = 5
        assertEquals(5, fibonacciRecursive(5))

        // f(6) = f(5) + f(4) = 4 + 3 = 8
        assertEquals(8, fibonacciRecursive(6))
    }

    @Test
    fun `fibonacciIterative should return n for n less than or equal to 2`() {
        assertEquals(0, fibonacciIterative(0))
        assertEquals(1, fibonacciIterative(1))
        assertEquals(1, fibonacciIterative(2))
    }

    @Test
    fun `fibonacciIterative should return sum of previous two numbers for n greater than 2`() {
        // f(3) = f(2) + f(1) = 1 + 1 = 2
        assertEquals(2, fibonacciIterative(3))

        // f(4) = f(3) + f(2) = 2 + 1 = 3
        assertEquals(3, fibonacciIterative(4))

        // f(5) = f(4) + f(3) = 3 + 2 = 5
        assertEquals(5, fibonacciIterative(5))

        // f(6) = f(5) + f(4) = 4 + 3 = 8
        assertEquals(8, fibonacciIterative(6))
    }

    @Test
    fun `fibonacciMemorization should return n for n less than or equal to 2`() {
        assertEquals(0, fibonacciMemoization(0))
        assertEquals(1, fibonacciMemoization(1))
        assertEquals(1, fibonacciMemoization(2))
    }

    @Test
    fun `fibonacciMemorization should return sum of previous two numbers for n greater than 2`() {
        // f(3) = f(2) + f(1) = 1 + 1 = 2
        assertEquals(2, fibonacciMemoization(3))

        // f(4) = f(3) + f(2) = 2 + 1 = 3
        assertEquals(3, fibonacciMemoization(4))

        // f(5) = f(4) + f(3) = 3 + 2 = 5
        assertEquals(5, fibonacciMemoization(5))

        // f(6) = f(5) + f(4) = 4 + 3 = 8
        assertEquals(8, fibonacciMemoization(6))
    }

    @Test
    fun `Comparing different fibonacci implementation times`() {
        var start = System.nanoTime()
        var result = fibonacciRecursive(23)
        var end = System.nanoTime()
        println("Time to resolve fibonacciRecursive(23): ${end - start} ns")
        assertEquals(28657, result)

        start = System.nanoTime()
        result = fibonacciIterative(23)
        end = System.nanoTime()
        println("Time to resolve fibonacciIterative(23): ${end - start} ns")
        assertEquals(28657, result)

        start = System.nanoTime()
        result = fibonacciMemoization(23)
        end = System.nanoTime()
        println("Time to resolve fibonacciMemoization(23): ${end - start} ns")
        assertEquals(28657, result)
    }
}

