package com.rileymathews.models

data class Transposition(val originalSong: Song, val stepsDown: Int) {
    val newSong = originalSong.transposeDown(stepsDown)
}

data class Transpositions(val transpositions: List<Transposition>)