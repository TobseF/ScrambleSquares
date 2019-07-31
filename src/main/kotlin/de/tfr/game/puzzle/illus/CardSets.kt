package de.tfr.game.puzzle.illus

enum class Solution {
    AADC, BDCA, GBED, ADFB,
    DGCH, CFBG, EHAF, FAGH,
    CAEH, BEFA, ACHE, GEEC,
    EDFG, FAHD, HBFA, EGDB;
}

enum class RealGame {
    ECFF, EFEC, ECCF, FEAE,
    FGBE, EHFG, CCAH, DHBB,
    BEFG, FGCE, ADGG, ACEH,
    FEHC, CFEC, GEFF, ECEF;
}

fun solutions() = Solution.values().map { Card(it.name) }
fun realGame() = RealGame.values().map { Card(it.name) }
