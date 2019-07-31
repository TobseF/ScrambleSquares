package de.tfr.game.puzzle.illus

class Table(val cards: List<List<Card.RotatedCard>> = placeShuffeled()) {

    companion object {

        fun placeShuffeled(): List<List<Card.RotatedCard>> {
            val nextCards = realGame().map { Card.RotatedCard(it) }.shuffled()

            return listOf(nextCards.subList(0, 4),
                    nextCards.subList(4, 8),
                    nextCards.subList(8, 12),
                    nextCards.subList(12, 16))
        }
    }

    fun check(): Boolean {
        for (row in 0..2) {
            for (column in 0..3) {
                val first = cards[row][column].card
                val seconds = cards[row + 1][column].card
                if (first.down() != seconds.up()) {
                    return false
                }
            }
        }
        for (row in 0..3) {
            for (column in 0..2) {
                val first = cards[row][column].card
                val second = cards[row][column + 1].card
                if (first.right() != second.left()) {
                    return false
                }
            }
        }
        return true
    }

    override fun toString() = cards.toString()

}
