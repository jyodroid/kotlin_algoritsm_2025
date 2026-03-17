package problems

import java.util.*
import kotlin.text.iterator

fun isCorrectString(s: String): Boolean {
    val stack = Stack<Char>()
    val  pairs = mapOf<Char, Char>(')' to '(', ']' to '[', '}' to '{')
    for (c in s) {
        if (pairs.containsKey(c)) {
            if (stack.isEmpty() || stack.pop() != pairs[c]) {
                return false
            }
        } else {
            stack.push(c)
        }
    }
    return stack.isEmpty()
}