package problems

import com.herrajeselpaisa.problems.findMostHighLines
import com.herrajeselpaisa.problems.pairWithTargetSum
import com.herrajeselpaisa.problems.trappedWater
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class PointersTest {

    @Test
    fun `Find if there is a pair of numbers in array which sum is 9`() {
        val nums = intArrayOf(1, 2, 4, 7, 11)
        val target = 9

        val result1 = pairWithTargetSum(nums, target)

        assertEquals(result1, true)
    }

    @Test
    fun `Find if there is a pair of numbers in array which sum is 22`() {
        val nums = intArrayOf(1, 2, 4, 7, 11)
        val target = 22

        val result = pairWithTargetSum(nums, target)

        assertEquals(result, false)
    }

    @Test
    fun `find two lines that, together with the x-axis, form a container such that the container holds the most water`() {
        val nums = intArrayOf(1, 8, 6, 2, 5, 4, 8, 3, 7)

        val result = findMostHighLines(nums)

        assertEquals(result, 49)
    }

    @Test
    fun `Return the total amount of water trapped`() {
        val nums = intArrayOf(0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1)

        val result = trappedWater(nums)

        assertEquals(result, 6)
    }
}