package problems

import com.herrajeselpaisa.problems.predictiveSearch
import com.herrajeselpaisa.problems.predictiveSearchWithRadix
import kotlin.test.Test
import kotlin.test.assertEquals

class TriesTest {
    val words = arrayOf("alphabet", "alpha", "apple", "apply", "ball", "bat", "applesauce", "applepie", "application")
    val prefix = "app"
    val expectedOutput = listOf("apple", "apply", "applesauce", "applepie", "application").sorted()

    @Test
    fun `quickly find all names that start with a specific prefix`() {
        val result = predictiveSearch(words, prefix)

        assertEquals(expectedOutput, result.sorted())
    }

    @Test
    fun `quickly find with radix all names that start with a specific prefix`() {
        val result = predictiveSearchWithRadix(words, prefix)

        assertEquals(expectedOutput, result.sorted())
    }
}