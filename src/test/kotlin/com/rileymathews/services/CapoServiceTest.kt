package com.rileymathews.services

import com.rileymathews.models.Key
import com.rileymathews.models.Song
import kotlin.test.Test
import kotlin.test.assertEquals

class CapoServiceTest {
    @Test fun testBasicOptimization() {
        val song = Song(listOf(Key.fromRoot("Ab")))

        val transpositions = CapoService(song).optimize()

        assertEquals("G", transpositions.transpositions[0].newSong.keys[0].root)
        assertEquals(1, transpositions.transpositions[0].stepsDown)
    }

    @Test fun testComplexOptimization() {
        val song = Song(listOf(Key.fromRoot("Ab"), Key.fromRoot("Bb")))

        val transpositions = CapoService(song).optimize()

        assertEquals("G", transpositions.transpositions[0].newSong.keys[0].root)
        assertEquals("A", transpositions.transpositions[0].newSong.keys[1].root)
        assertEquals(1, transpositions.transpositions[0].stepsDown)
    }

    @Test fun testSortOptionsByMostCagedKeys() {
        val song = Song(listOf(Key.fromRoot("B"), Key.fromRoot("D")))

        val transpositions = CapoService(song).optimize()

        assertEquals("A", transpositions.transpositions[0].newSong.keys[0].root)
        assertEquals("C", transpositions.transpositions[0].newSong.keys[1].root)
        assertEquals(2, transpositions.transpositions[0].stepsDown)
    }
}