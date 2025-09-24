package com.herrajeselpaisa.problems

/**
 * Find in an array the index of two numbers that the sum is equal to a target value
 */

/**
 * O(n^2)
 */
fun findTwoNumbers(target: Int, nums: IntArray): IntArray {
    // 1. sort
    nums.sort()

    //2. cut the array
    val newArray = nums.filter { it <= target }

    //3. iterate
    for (indx in 0 until newArray.size) {
        for (indx2 in indx until newArray.size) {
            if (newArray[indx] + newArray[indx2] == target) {
                return intArrayOf(indx, indx2)
            }
        }
    }


    return intArrayOf()
}

/**
 * O(n)
 */
fun findTwoNumbersHashMap(target: Int, nums: IntArray): IntArray {
    val map = mutableMapOf<Int, Int>()
    for ((i, num) in nums.withIndex()) {
        val complement = target - num
        if (map.containsKey(complement)) {
            return intArrayOf(map[complement]!!, i)
        }
        map[num] = i
    }

    return intArrayOf()
}

/**
 * O(nlogn)
 */
fun findTwoNumbersPointers(target: Int, nums: IntArray): IntArray {
    // keep track of original indices
    val indexed = nums.mapIndexed { i, v -> i to v }.sortedBy { it.second }

    var left = 0
    var right = indexed.size - 1

    while (left < right) {
        val sum = indexed[left].second + indexed[right].second
        when {
            sum == target -> return intArrayOf(indexed[left].first, indexed[right].first)
            sum < target -> left++
            else -> right--
        }
    }

    return intArrayOf()
}