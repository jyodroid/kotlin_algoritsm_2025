package problems

import com.herrajeselpaisa.problems.firstNonRepeatedChar
import com.herrajeselpaisa.problems.firstNonRepeatedCharBruteForce
import com.herrajeselpaisa.problems.mostFrequent
import com.herrajeselpaisa.problems.mostFrequent2
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class FirstNonDuplicatedTest {

    @Test
    fun `Find the first element non repeated in the string leetcode `(){
        val input = "leetcode"
        val result1 = firstNonRepeatedCharBruteForce(input)
        val result2 = firstNonRepeatedChar(input)

        assertEquals(result1, result2)
        assertEquals(result1, 'l')
        assertEquals(result2, 'l')
    }

    @Test
    fun `Find the first element non repeated in the string aabbcc or return _`(){
        val input = "aabbcc"
        val result1 = firstNonRepeatedCharBruteForce(input)
        val result2 = firstNonRepeatedChar(input)

        assertEquals(result1, result2)
        assertEquals(result1, '_')
        assertEquals(result2, '_')
    }

    @Test
    fun `find the k most frequent elements from an array`(){

        val nums = intArrayOf(4,1,1,2,2,3,3,3)
        val k = 2

        val result = mostFrequent(nums, k)
        assertEquals(listOf(3,1), result.toList())
    }

    @Test
    fun `find the k most frequent elements from an array and on repeated frequency, return the lowest value`(){
        val nums = intArrayOf(4,1,1,2,2,3,3,3)
        val k = 2

        val result = mostFrequent2(nums, k)
        assertEquals(listOf(3,1), result.toList())
    }
}