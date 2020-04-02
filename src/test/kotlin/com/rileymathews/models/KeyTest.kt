package com.rileymathews.models

import kotlin.test.Test
import kotlin.test.assertEquals

internal class KeyTest {
    @Test fun testCanConstructKeyFromRootNote() {
        val key = Key.fromRoot("G")

        assertEquals("G", key.root, "expect key root to be G")
    }

    @Test fun testCanConstructKeyFromIndex() {
        val key = Key.fromIndex(0)

        assertEquals("A", key.root, "expect key root to be A")
    }

    @Test fun testIsCagedKey() {
        val nonCagedKey = Key.fromRoot("Ab")
        val cagedKey = Key.fromRoot("A")

        assertEquals(true, cagedKey.isCagedKey())
        assertEquals(false, nonCagedKey.isCagedKey())
    }

    @Test fun testTransposeUp() {
        val key = Key.fromRoot("A").transposeUp(2)

        assertEquals("B", key.root)
    }

    @Test fun testTranposeDown() {
        val key = Key.fromRoot("G").transposeDown(2)

        assertEquals("F", key.root)
    }
}