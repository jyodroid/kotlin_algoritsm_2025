package problems

import com.herrajeselpaisa.problems.findTwoNumbers
import com.herrajeselpaisa.problems.findTwoNumbersHashMap
import com.herrajeselpaisa.problems.findTwoNumbersPointers
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Sum2Test {
    @Test
    fun `Find in the the array two numbers which sum is equals to 13`() {
        val nums = intArrayOf(2, 7, 11, 15)
        val target = 13

        val result1 = findTwoNumbers(target, nums).toList()
        val result2 = findTwoNumbersHashMap(target, nums).toList()
        val result3 = findTwoNumbersPointers(target, nums).toList()

        assertEquals(result1, result2)
        assertEquals(result2, result3)
        assertEquals(result1, listOf(0, 2))
    }
}