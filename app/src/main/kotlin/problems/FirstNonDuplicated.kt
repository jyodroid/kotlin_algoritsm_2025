package com.herrajeselpaisa.problems

/**
 * Given a string s, return the first non-repeated character.
 */

fun firstNonRepeatedChar(s: String): Char {
    val freq = mutableMapOf<Char, Int>()

    // Count frequencies
    for (c in s) {
        freq[c] = freq.getOrDefault(c, 0) + 1
    }

    // Find first non-repeated
    for (c in s) {
        if (freq[c] == 1) return c
    }

    return '_'
}

fun firstNonRepeatedCharBruteForce(string: String): Char {
    // compare each character and search for repeated
    var first: Char? = null
    val repeatedArrayList = ArrayList<Char>()
    for (indx in 0 until string.length) {
        first = string[indx]
        if (first in repeatedArrayList) {
            first = null
            continue
        }
        for (indx2 in indx + 1 until string.length) {
            if (string[indx2] == first) {
                repeatedArrayList.add(first)
                first = null
            }
        }
        if (first != null) {
            break
        }
    }

    return first ?: '_'
}

/**
 * You’re given an array of integers nums and an integer k.
 * Return the k most frequent elements in nums.
 * If multiple numbers have the same frequency, return any order.
 *
 * Example:
 *
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 */
fun mostFrequent(nums: IntArray, k: Int): IntArray {
    val freq = mutableMapOf<Int, Int>()
    for (n in nums) {
        freq[n] = freq.getOrDefault(n, 0) + 1
    }

    // priority Queue
    val pq = java.util.PriorityQueue<Map.Entry<Int, Int>> { a, b ->
        b.value - a.value // max-heap by frequency
    }
    pq.addAll(freq.entries)

    val res = IntArray(k)
    repeat(k) { i ->
        res[i] = pq.poll().key
    }
    return res
}


fun mostFrequent2(nums: IntArray, k: Int): IntArray {
    val freq = mutableMapOf<Int, Int>()
    for (n in nums) {
        freq[n] = freq.getOrDefault(n, 0) + 1
    }

    //    If frequencies are equal, orders by value descending (so that when popping, the larger number is removed
    //    first — this leaves the smaller in the heap).
    val pq = java.util.PriorityQueue<Map.Entry<Int, Int>> { a, b ->
        if (a.value == b.value) b.key - a.key
        else a.value - b.value
    }

//    Fill heap with at most k elements
    for (entry in freq.entries) {
        pq.offer(entry)
        if (pq.size > k) pq.poll()
    }

    // pq.poll() will give you from smallest → largest, but we need largest freq first.
    val res = IntArray(k)
    for (i in (k - 1) downTo 0) {
        res[i] = pq.poll().key
    }

    return res
}