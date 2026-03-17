package problems

import kotlin.text.iterator

//You are designing a feature for a contacts app. Given a large list of names, you need to quickly find all
// names that start with a specific prefix.
//
//Input: * List: ["alphabet", "alpha", "apple", "apply", "ball", "bat"]
//
//Query: "app"
//
//Expected Output: ["apple", "apply"]
// The Trie (prefix tree)
fun predictiveSearch(strs: Array<String>, query: String): List<String> {
    val trie = Trie()
    for (str in strs) {
        trie.insert(str)
    }

    return trie.findWordsWithPrefix(query)
}

fun predictiveSearchWithRadix(strs: Array<String>, query: String): List<String> {
    val trie = RadixTrie()
    for (str in strs) {
        trie.insert(str)
    }

    return trie.findWordsWithPrefix(query)
}

// recursive call
private fun collectAllWords(node: TrieNode, currentPrefix: StringBuilder, results: MutableList<String>) {
    if (node.isEndOfWord) {
        results.add(currentPrefix.toString())
    }
    node.children.forEach { (char, childNode) ->
        currentPrefix.append(char)
        collectAllWords(childNode, currentPrefix, results)
        currentPrefix.deleteCharAt(currentPrefix.length - 1) // backtrack
    }
}

private class TrieNode {
    val children = mutableMapOf<Char, TrieNode>()
    var isEndOfWord = false
}

private class Trie {
    private val root = TrieNode()

    fun insert(word: String) {
        var current = root
        for (c in word) {
            current = current.children.getOrPut(c) { TrieNode() }
        }
        current.isEndOfWord = true
    }

    fun findWordsWithPrefix(prefix: String): List<String> {
        var current = root
        prefix.forEach { c ->
            current = current.children[c] ?: return emptyList()
        }
        val results = mutableListOf<String>()
        collectAllWords(current, StringBuilder(prefix), results)
        return results
    }
}

// recursive call
private fun collectAllWords(node: RadixTrieNode, currentPrefix: StringBuilder, results: MutableList<String>) {
    if (node.isEndOfWord) {
        results.add(currentPrefix.toString())
    }
    node.children.forEach { (fragment, childNode) ->
        val lengthBefore = currentPrefix.length
        currentPrefix.append(fragment)
        collectAllWords(childNode, currentPrefix, results)
        currentPrefix.setLength(lengthBefore) // backtrack
    }
}

private class RadixTrieNode {
    val children = mutableMapOf<String, RadixTrieNode>()
    var isEndOfWord = false
}

private class RadixTrie {
    private val root = RadixTrieNode()

    // Calculating that shared length (the LCP or Longest Common Prefix) is the heart of the Radix Tree.
    private fun getSharedPrefixLength(string1: String, string2: String): Int {
        var index = 0
        while (index < string1.length && index < string2.length && string1[index] == string2[index]) {
            index++
        }

        return index
    }

    //    The 3 Pillars of Radix Insertion
//    To make this robust, your logic needs to handle these three states:
//
//    No Match: No child starts with word[0]. Just add a new node.
//
//    Full Match: The existingKey is a perfect prefix of word (or vice versa). We move current to that child and continue with the leftover string.
//
//    Partial Match (The Split): They share some characters (LCP > 0) but diverge. We perform the "surgery" you wrote.
    fun insert(word: String) {
        var current = root
        var remainingWord = word

        while (remainingWord.isNotEmpty()) {
            // 1. Find the child that shares a start character
            val existingKey = current.children.keys.find { it[0] == remainingWord[0] }

            if (existingKey == null) {//No Match: No child starts with word[0]
                val newNode = RadixTrieNode().apply { isEndOfWord = true }
                current.children[remainingWord] = newNode
                return
            }

            val sharedLen = getSharedPrefixLength(remainingWord, existingKey)
            val existingNode = current.children[existingKey]!!

            if (sharedLen == existingKey.length) {// Full Match: The existingKey is a perfect prefix of word
                current = existingNode
                remainingWord = remainingWord.substring(sharedLen) // continue with the leftover string

                if (remainingWord.isEmpty()) {
                    current.isEndOfWord = true
                    return
                }
            } else { // Partial Match (The Split): They share some characters
                // split
                val sharedPrefix = existingKey.substring(0, sharedLen)
                val oldSuffix = existingKey.substring(sharedLen)
                val newSuffix = remainingWord.substring(sharedLen)

                val intermediateNode = RadixTrieNode()

                // remove old long key and replace with shared prefix
                current.children.remove(existingKey)
                current.children[sharedPrefix] = intermediateNode

                // move the original node and all its children to the old suffix
                intermediateNode.children[oldSuffix] = existingNode

                if (newSuffix.isNotEmpty()) {
                    // add the new suffix as a child of the intermediate node
                    intermediateNode.children[newSuffix] = RadixTrieNode().apply { isEndOfWord = true }
                } else {
                    // if the new suffix is empty, mark the intermediate node as end of word
                    intermediateNode.isEndOfWord = true
                }
                return
            }
        }
    }

    fun findWordsWithPrefix(prefix: String): List<String> {
        var current = root
        var remainingPrefix = prefix

        while (remainingPrefix.isNotEmpty()) {
            val edgeKey = current.children.keys.find { it[0] == remainingPrefix[0] } ?: return emptyList()
            val node = current.children[edgeKey]!!

            val sharedLen = getSharedPrefixLength(remainingPrefix, edgeKey)

            if (sharedLen == remainingPrefix.length) {
                //we found the node, everything under here is a match!
                val results = mutableListOf<String>()
                // we need to remember the part of the word we skipped
                val baseWord = prefix.substring(0, prefix.length - remainingPrefix.length) + edgeKey

                collectAllWords(node, StringBuilder(baseWord), results)
                return results
            } else if (sharedLen < remainingPrefix.length) {
                // we matched part of the prefix, but we need to keep going
                remainingPrefix = remainingPrefix.substring(sharedLen)
                current = node
            } else {
                // The prefix and edge diverged
                return emptyList()
            }
        }

        return emptyList()
    }
}