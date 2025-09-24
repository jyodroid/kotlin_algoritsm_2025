package com.herrajeselpaisa.problems

import kotlin.math.min

/**
 * Given a sorted array of integers nums and a target value, return true if there exist two numbers such that their sum equals the target.
 */
fun pairWithTargetSum(nums: IntArray, target: Int): Boolean {
    var left = 0
    var rigth = nums.size - 1

    while (left < rigth) {
        val sum = nums[left] + nums[rigth]
        when {
            sum == target -> return true
            sum < target -> left++
            sum > target -> rigth--
        }
    }

    return false
}

/**
 * You are given an integer array height. Each element represents a vertical line at index i with height height[i].
 *
 * The task is to find two lines that, together with the x-axis, form a container such that the container holds the most water.
 */
fun findMostHighLines(heigh: IntArray): Int {
    var left = 0
    var right = heigh.size - 1

    var maxArea = 0

    while (left < right) {
        val area = min(heigh[left], heigh[right]) * (right - left)
        maxArea = maxOf(maxArea, area)
        when {
            heigh[left] < heigh[right] -> left++
            else -> right--
        }
    }

    return maxArea
}

/**
 * You are given an array height where each element represents the elevation map at that position.
 * After raining, some bars trap water between them.
 *
 * Return the total amount of water trapped.
 */

fun trappedWater(height: IntArray): Int{
    var left = 0
    var right = height.size -1
    var maxLeft =0
    var maxRight = 0

    var trapped = 0

    while (left < right){
        if (height[left] < height[right] ){
            if (height[left] > maxLeft){
                maxLeft = height[left]
            }else {
                trapped += maxLeft - height[left]
            }
            left++
        } else {
            if (height[right] >= maxRight){
                maxRight = height[right]
            } else {
                trapped += maxRight - height[right]
            }
            right --
        }
    }

    return trapped
}
