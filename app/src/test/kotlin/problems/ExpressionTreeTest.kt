package problems

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class ExpressionTreeTest {
    @Test
    fun `Evaluate expression tree to 31`() {
        val innerLeft = Node.Operation('+', Node.Numeric(5), Node.Numeric(9))
        val rightNode = Node.Operation(
            '*',
            left = innerLeft,
            right = Node.Numeric(2),
        )
        val node = Node.Operation('+', Node.Numeric(3), rightNode)
        val calculation = evaluateExpressionTree(node)

        assertEquals(31, calculation)
    }
}