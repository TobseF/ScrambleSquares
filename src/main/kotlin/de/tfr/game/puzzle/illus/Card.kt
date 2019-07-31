package de.tfr.game.puzzle.illus

import kotlin.random.Random

class Card(val name: String) {

    val chars = name.toCharArray().map { it.toString() }

    fun left() = chars[3]
    fun up() = chars[0]
    fun down() = chars[2]
    fun right() = chars[1]


    class RotatedCard(val card: Card, val rotation: Rotation = Rotation.D0.random()) {
        override fun toString(): String {
            return card.place(rotation)
        }
    }

    enum class Rotation {
        D0, D90, D180, D270;

        fun random() = values()[Random.nextInt(0, 3)]
    }

    fun place(rotation: Rotation): String {
        val chars = chars
        return when (rotation) {
            Rotation.D0 -> name
            Rotation.D90 -> "${chars[3]}${chars[0]}${chars[1]}${chars[2]}"
            Rotation.D180 -> "${chars[2]}${chars[3]}${chars[0]}${chars[1]}"
            Rotation.D270 -> "${chars[1]}${chars[2]}${chars[3]}${chars[0]}"
        }
    }

}
