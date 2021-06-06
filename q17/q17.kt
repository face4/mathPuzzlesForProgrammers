package q17

fun main() {
    val dp = List(2) { MutableList(30) { 0L } }
    dp[0][0] = 1
    dp[1][0] = 1
    for (i in 1 until 30) {
        dp[0][i] += dp[0][i - 1] + dp[1][i - 1]
        dp[1][i] += dp[0][i - 1]
    }
    println(dp[0][29] + dp[1][29])
}