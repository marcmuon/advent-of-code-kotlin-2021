fun main() {
    fun part1(input: List<String>): Int {
        val moves = input.map{it.split(" ")}
        var position = 0
        var depth = 0
        for ((direction, amount) in moves) {
            val amount = amount.toInt()
            when (direction) {
                "forward" -> position += amount
                "up" -> depth -= amount
                "down" -> depth += amount
            }
        }
        return position * depth
    }

    fun part2(input: List<String>): Int {
        val moves = input.map{it.split(" ")}
        var position = 0
        var depth = 0
        var aim = 0
        for ((direction, amount) in moves) {
            val amount = amount.toInt()
            when (direction) {
                "forward" -> {
                    position += amount
                    depth += (aim * amount)
                }
                "up" -> aim -= amount
                "down" -> aim += amount
            }
        }
        return position * depth
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day02_test")
    check(part1(testInput) == 150)
    check(part2(testInput) == 900)

    val input = readInput("Day02")
    println(part1(input))
    println(part2(input))
}
