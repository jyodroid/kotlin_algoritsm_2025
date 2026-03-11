package com.herrajeselpaisa.problems

import kotlin.math.abs

// Least Common Multiple (LCM) of two numbers is the smallest positive number that is divisible by both numbers.
// LCM(a, b) = |a * b|/GCD(a, b)
private fun leastCommonMultiple(a: Int, b: Int): Int {
    val gcd = greatestCommonDivisor(a, b)
//    return (a * b) / gcd // avoid int overflow by dividing before multiplying
    return a / gcd * b
}

// Euclid's algorithm is based on the principle that the greatest common divisor of two numbers does not change if
// the larger number is replaced by its difference with the smaller number.
// For example, GCD(48, 18) is the same as GCD(30, 18) because 48 - 18 = 30.
// This process can be repeated until one of the numbers becomes zero, at which point the other number is the GCD.
private tailrec fun greatestCommonDivisor(a: Int, b: Int): Int {// a should be bigger than b
    if (b == 0) return a
    return greatestCommonDivisor(b, a % b)
}

fun greatestCommonDivisor(numbers: Array<Int>): Int =
    numbers.reduce { a, b -> if (a > b ) greatestCommonDivisor(a, b) else greatestCommonDivisor(b, a % b) }

fun leastCommonMultiple(numbers: Array<Int>): Int =
    numbers.reduce { a, b -> leastCommonMultiple(abs(a), abs(b)) }

fun bridge(a: Array<Int>, b: Array<Int>): Int {
    val lcmForA = leastCommonMultiple(a)
    val gcdForB = greatestCommonDivisor(b)

    if (lcmForA > gcdForB) return 0 // if the least common multiple of a is greater than the greatest common divisor of b, there are no numbers that are multiples of lcmForA and divisors of gcdForB

    // so I need to go through all multiples from lcmForA to gcdForB and check when the leftover is equal to 0
    var counter = 0
    var multiple = lcmForA
    while (multiple <= gcdForB) {
        if (gcdForB % multiple == 0) {
            counter++
        }
        multiple += lcmForA
    }

    return counter
}