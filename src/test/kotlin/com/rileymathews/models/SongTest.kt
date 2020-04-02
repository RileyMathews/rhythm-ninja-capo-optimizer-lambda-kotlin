package com.rileymathews.models

import kotlin.test.Test
import kotlin.test.assertEquals


class SongTest {
    @Test fun testTransposeUp() {
        val keyList = listOf(Key.fromRoot("G"), Key.fromRoot("A"))
        val song = Song(keyList)

        val newSong = song.transposeUp(2)

        assertEquals("A", newSong.keys[0].root, "assert first key was transposed correctly")
        assertEquals("B", newSong.keys[1].root, "assert first key was transposed correctly")
    }

    @Test fun testTransposeDown() {
        val keyList = listOf(Key.fromRoot("G"), Key.fromRoot("A"))
        val song = Song(keyList)

        val newSong = song.transposeDown(2)

        assertEquals("F", newSong.keys[0].root, "assert first key was transposed correctly")
        assertEquals("G", newSong.keys[1].root, "assert first key was transposed correctly")
    }
}