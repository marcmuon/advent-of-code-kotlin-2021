fun main() {
    fun part1(input: List<String>): Int {
        val nums = input.map{it.toInt()}
        var increasingCt = 0
        var lastNum = nums[0]
        for (n in nums) {
            if (n > lastNum) {
                increasingCt++
            }
            lastNum = n
        }
        return increasingCt
    }

    fun part2(input: List<String>): Int {
        val nums = input.map{it.toInt()}
        var increaseCt = 0
        var lastWindowSum = nums.slice(0 until 3).sum()
        for (i in 0 until nums.size-2) {
            val currWindowSum = nums.slice(i until i+3).sum()
            if (currWindowSum > lastWindowSum) {
                increaseCt++
            }
            lastWindowSum = currWindowSum
        }
        return increaseCt
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 7)
    check(part2(testInput) == 5)

    val input = readInput("Day01")
    println(part1(input))
    println(part2(input))
}
