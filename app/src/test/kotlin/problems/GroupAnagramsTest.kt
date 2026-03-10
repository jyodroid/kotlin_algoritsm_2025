package problems

import com.herrajeselpaisa.problems.groupAnagrams
import com.herrajeselpaisa.problems.groupAnagrams2
import com.herrajeselpaisa.problems.groupAnagrams3
import kotlin.test.Test
import kotlin.test.assertEquals

class GroupAnagramsTest {
    val testInput = arrayOf("eat", "tea", "tan", "ate", "nat", "bat")
    val testOutput = listOf(listOf("eat", "tea", "ate"), listOf("tan", "nat"), listOf("bat"))

    @Test
    fun `List of lists, where each sub-list contains strings that are anagrams of each other -- 1`() {
        val result = groupAnagrams(testInput)
        assertEquals(testOutput, result)
    }

    @Test
    fun `List of lists, where each sub-list contains strings that are anagrams of each other -- 2`() {
        val result = groupAnagrams2(testInput)
        assertEquals(testOutput, result)
    }

    @Test
    fun `List of lists, where each sub-list contains strings that are anagrams of each other -- 3`() {
        val result = groupAnagrams3(testInput)
        assertEquals(testOutput, result)
    }
}