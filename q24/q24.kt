package q24

fun main() {
    val pat = MutableList(9) { listOf(it) }
    pat += mutableListOf(
        listOf(0, 1),
        listOf(1, 2),
        listOf(6, 7),
        listOf(7, 8),
        listOf(0, 3),
        listOf(2, 5),
        listOf(3, 6),
        listOf(5, 8)
    )
    val patbit = pat.map { it.sumOf { a -> 1 shl a } }
    val dp = MutableList(1 shl 9) { 0 }
    dp[0] = 1
    for (i in 0 until (1 shl 9)) {
        for (j in patbit) {
            if (i and j > 0) continue
            dp[i or j] += dp[i]
        }
    }
    println(dp.last())
}