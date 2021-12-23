fun main() {
    fun part1(input: List<String>): Int {
        var depth = 0
        var horizontalPosition = 0
        val operations = input.map { it.split(" ") }
        for ((direction, amountString) in operations) {
            val amount = amountString.toInt()
            when (direction) {
                "up" -> depth -= amount
                "down" -> depth += amount
                "forward" -> horizontalPosition += amount
            }
        }
        return depth * horizontalPosition
    }

    fun part2(input: List<String>): Int {
        var aim = 0
        var depth = 0
        var horizontalPosition = 0
        val operations = input.map { it.split(" ") }
        for ((direction, amountString) in operations) {
            val amount = amountString.toInt()
            when (direction) {
                "up" -> aim -= amount
                "down" -> aim += amount
                "forward" -> {
                    horizontalPosition += amount
                    depth += amount * aim
                }
            }
        }
        return depth * horizontalPosition
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day02_test")
    check(part1(testInput) == 150)
    check(part2(testInput) == 900)

    val input = readInput("Day02")
    println(part1(input))
    println(part2(input))
}
