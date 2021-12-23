//jetbrains version from YT

private fun List<String>.countBitsInColumn(column: Int): BitCount {
    var zeroes = 0
    var ones = 0
    for (line in this) {
        if (line[column] == '0') zeroes++ else ones++
    }
    return BitCount(zeroes, ones)
}

data class BitCount(val zeroes: Int, val ones: Int)

private fun String.invertBinaryString() = this
    .asIterable()
    .joinToString("") {if (it == '0') "1" else "0"}

fun main() {
    fun part1(input: List<String>): Int {
        val columns = input[0].indices
        val gammaRate = buildString {
            for (column in columns) {
                val (zeroes, ones) = input.countBitsInColumn(column)
                val commonBit = if(zeroes > ones) "0" else "1"
                append(commonBit)
            }
        }
        val epsilonRate = gammaRate.invertBinaryString()
        return gammaRate.toInt(2) * epsilonRate.toInt(2)
    }


    fun part2() {
        //TODO
    }

    val testInput = readInput("Day03_test")
    check(part1(testInput) == 198)
//    check(part2(testInput) == 0)
//
    val input = readInput("Day03")
    println(part1(input))
//    println(part2(input))
}


