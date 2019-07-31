package de.tfr.game.puzzle.illus

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue


internal class CardTest {

    @Test
    fun placeCart() {
        assertEquals("FGBE", Card("FGBE").name)
        assertEquals("F", Card("FGBE").up())
        assertEquals("G", Card("FGBE").right())
        assertEquals("B", Card("FGBE").down())
        assertEquals("E", Card("FGBE").left())

        assertEquals("FGBE", Card("FGBE").place(Card.Rotation.D0))
        assertEquals("EFGB", Card("FGBE").place(Card.Rotation.D90))
        assertEquals("BEFG", Card("FGBE").place(Card.Rotation.D180))
        assertEquals("GBEF", Card("FGBE").place(Card.Rotation.D270))
    }

    @Test
    fun tableCardSize() {
        assertEquals(realGame().size, Table().cards.flatten().toSet().size)
    }

    @Test
    fun printTable() {
        println(Table().cards)
    }

    @Test
    fun tableCheck() {
        val nextCards = solutions().toList().map { Card.RotatedCard(it, Card.Rotation.D0) }

        val cards = listOf(nextCards.subList(0, 4),
                nextCards.subList(4, 8),
                nextCards.subList(8, 12),
                nextCards.subList(12, 16))
        print(cards)
        assertTrue(Table(cards).check())
    }

    /**
     * Search solution by creating random boards
     */
    @Test
    fun findTableByShuffle() {
        var found = false
        var counter = 0
        val time = System.currentTimeMillis()
        while (!found) {
            counter++
            val table = Table()
            if (counter.rem(100_000_000) == 0) {
                println(counter)
                println(System.currentTimeMillis() - time)
            }
            if (table.check()) {
                found = true
                println(table.toString())
            }
        }
    }
}
