package com.rileymathews.models

data class Song(val keys: List<Key>) {
    fun transposeUp(halfSteps: Int): Song {
        val newKeys = keys.map { it.transposeUp(halfSteps) }
        return Song(newKeys)
    }

    fun transposeDown(halfSteps: Int): Song {
        val newKeys = keys.map { it.transposeDown(halfSteps) }
        return Song(newKeys)
    }
}