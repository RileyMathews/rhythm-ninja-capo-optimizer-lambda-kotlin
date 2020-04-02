package com.rileymathews.services

import com.rileymathews.models.Key
import com.rileymathews.models.Song
import com.rileymathews.models.Transposition
import com.rileymathews.models.Transpositions

class CapoService(val originalSong: Song) {
    fun optimize(): Transpositions {
        val transpositionsArray = (0..5).map { Transposition(originalSong, it) }
        val transpositionsWithCagedKeys = transpositionsArray.filter { transposition -> transposition.newSong.keys.any { it.isCagedKey() } }
        val sortedTranspositionsByCagedCount = transpositionsWithCagedKeys.sortedByDescending { transposition -> transposition.newSong.keys.count { key -> key.isCagedKey() }}
        return Transpositions(sortedTranspositionsByCagedCount)
    }
}