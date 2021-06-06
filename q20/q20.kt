package q20

fun main() {
    val numbers = MutableList(16) { it + 1 }
    numbers[15] = 14
    numbers[11] = 10
    val count = MutableList(16 * (16 + 1) / 2 + 1) { 0 }
    for (i in 1 until (1 shl 16)) {
        count[(0 until 16).filter { i and (1 shl it) > 0 }.sumOf { numbers[it] }]++
    }
    val answer = count.indexOf(count.maxOrNull())
    println("$answer ${count[answer]}")
}