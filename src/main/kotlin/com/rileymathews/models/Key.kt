package com.rileymathews.models

import com.rileymathews.config.cagedKeys
import com.rileymathews.config.indexToNote

data class Key(val root: String, val chromaticIndex: Int) {
    companion object {
        fun fromIndex(index: Int): Key {
            val root = indexToNote[index] ?: throw RuntimeException("index not valid")
            return Key(root, index)
        }

        fun fromRoot(root: String): Key {
            val index = indexToNote.entries.associate { (k, v) -> v to k }[root] ?: throw RuntimeException("root not valid")
            return Key(root, index)
        }
    }

    fun isCagedKey(): Boolean {
        return cagedKeys.any { it == root }
    }

    fun transposeUp(halfSteps: Int): Key {
        val transposeSteps = chromaticIndex + halfSteps
        val elevenBaseIndex = transposeSteps % 12
        return fromIndex(elevenBaseIndex)
    }

    fun transposeDown(halfSteps: Int): Key {
        val transposeSteps = chromaticIndex - halfSteps
        val elevenBaseIndex = if (transposeSteps < 0) transposeSteps + 12 else transposeSteps
        return fromIndex(elevenBaseIndex)

    }
}