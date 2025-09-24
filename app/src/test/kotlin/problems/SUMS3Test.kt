package problems

import com.herrajeselpaisa.problems.sumsProblem3
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class SUMS3Test {
    @Test
    fun `find i array, different Triple that makes the sum equals to 0`() {
        val nums = intArrayOf(-1, 0, 1, 2, -1, -4)

        val result = sumsProblem3(nums)

        assertEquals(result, listOf(listOf(-1, -1, 2), listOf(-1, 0, 1)))
    }
}