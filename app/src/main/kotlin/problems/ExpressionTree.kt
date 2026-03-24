package problems

sealed class Node {
    data class Numeric(val value: Int) : Node()
    data class Operation(val value: Char, val left: Node, val right: Node) : Node()
}

// cannot use tailrec because recursion is not the last
fun evaluateExpressionTree(node: Node): Int{
    return when(node){
        is Node.Numeric -> node.value
        is Node.Operation -> {
            val leftValue = evaluateExpressionTree(node.left)
            val rightValue = evaluateExpressionTree(node.right)

            when(node.value){
                '+' -> leftValue + rightValue
                '*' -> leftValue * rightValue
                else -> 0
            }
        }
    }
}
