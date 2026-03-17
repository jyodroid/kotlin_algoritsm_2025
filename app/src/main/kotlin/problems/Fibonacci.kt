package problems

// Recursive approach
fun fibonacciRecursive(n: Int): Long {
    if (n < 0) throw IllegalArgumentException("Input must be a non-negative integer")
    if (n <= 1) return n.toLong()
    return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2)
}

// tailrec keyword allows the function to call itself without growing the call stack, preventing stack overflow for large n
// Essentially, it turns your recursion into a while loop behind the scenes
tailrec fun fibonacciTail(n: Int, a: Long = 0, b: Long = 1): Long {
    // Base case: we've reached the target
    if (n == 0) return a
    if (n == 1) return b

    // Recursive step: we pass the "next" values down
    // Notice: there is no math happening AFTER the call!
    return fibonacciTail(n - 1, b, a + b)
}

// Iterative approach
fun fibonacciIterative(n: Int): Long {
    if (n < 0) throw IllegalArgumentException("Input must be a non-negative integer")
    if (n <= 1) return n.toLong()
    var prev1 = 0L
    var prev2 = 1L
    var value = 1L
    var count = 2
    while (count <= n) {
        value = prev2 + prev1
        prev1 = prev2
        prev2 = value
        count++
    }

    return value
}

// Dynamic programming approach with memoization
fun fibonacciMemoization(n: Int, memo: MutableMap<Int, Long> = mutableMapOf()): Long {
    if (n < 0) throw IllegalArgumentException("Input must be a non-negative integer")
    if (n <= 1) return n.toLong()
    if (memo.containsKey(n)) return memo[n]!!
    val value = fibonacciMemoization(n - 1, memo) + fibonacciMemoization(n - 2, memo)
    memo[n] = value
    return value
}