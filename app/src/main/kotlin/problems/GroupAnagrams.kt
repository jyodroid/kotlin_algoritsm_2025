package com.herrajeselpaisa.problems

//Imagine you are building a Task Management app. You receive a list of task strings, where each string is a category name.
// Some names are anagrams of each other (e.g., "now" and "own"). To clean up the UI, you need to group these anagrams together.
//
//The Goal: Write a function that takes an array of strings and returns a list of lists, where each sub-list contains strings
// that are anagrams of each other.
//
//Input: ["eat", "tea", "tan", "ate", "nat", "bat"]
//
//Output: [["eat", "tea", "ate"], ["tan", "nat"], ["bat"]]

fun groupAnagrams(strs: Array<String>): List<List<String>> {
    val anagramMap = mutableMapOf<String, MutableList<String>>()

    for (str in strs) {
        val sortedStr = str.toCharArray().sorted().joinToString("")
        anagramMap.getOrPut(sortedStr) { mutableListOf() }.add(str)
//        if (sortedStr !in anagramMap) {
//            anagramMap[sortedStr] = mutableListOf()
//        }
//        anagramMap[sortedStr]?.add(str)
    }

    return anagramMap.values.toList()
}

// O(nklogk)
fun groupAnagrams2(strs: Array<String>): List<List<String>> =
    strs.groupBy { it.toCharArray().sorted().joinToString("") }.values.toList()

// O(k)
fun groupAnagrams3(strs: Array<String>): List<List<String>> {
    val anagramMap = mutableMapOf<String, MutableList<String>>()

    for (str in strs) {
        val count = IntArray(26)
        for (c in str) {
            count[c - 'a']++
        }
        val key = count.joinToString("#")
        anagramMap.getOrPut(key) { mutableListOf() }.add(str)
//        if (key !in anagramMap) {
//            anagramMap[key] = mutableListOf()
//        }
//        anagramMap[key]?.add(str)
    }

    return anagramMap.values.toList()
}