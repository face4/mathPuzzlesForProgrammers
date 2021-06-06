package q23

fun main() {
    val dp = List(25) { MutableList(35) { 0 } }
    dp[0][10] = 1
    for (i in 0 until 24) {
        for (j in 1 until 34) {
            dp[i + 1][j - 1] += dp[i][j]
            dp[i + 1][j + 1] += dp[i][j]
        }
    }
    println(dp[24].drop(1).sum())
}