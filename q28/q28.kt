package q28

import kotlin.math.max

fun main() {
    val p = listOf(
        40 to 11000,
        30 to 8000,
        24 to 400,
        20 to 800,
        14 to 900,
        16 to 1800,
        15 to 1000,
        40 to 7000,
        10 to 100,
        12 to 300
    )
    val dp = MutableList(151) { -10000000 }
    dp[0] = 0
    for ((i, j) in p) {
        for (k in 150 downTo i) {
            dp[k] = max(dp[k], dp[k - i] + j)
        }
    }
    print(dp.maxOrNull() ?: 0)
}