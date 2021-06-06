package q15

fun main() {
    val dp = List(10) { MutableList(10) { 0 } }
    dp[0][0] = 1
    for (i in 1..9) {
        for (j in 1..9) {
            for (k in 1..4) {
                if (j - k < 0) continue
                dp[i][j] += dp[i - 1][j - k]
            }
        }
    }

    var answer = 0
    for (i in 1..9) {
        for (j in 1..9) {
            answer += dp[i][j] * dp[i][10 - j]
        }
    }

    println(answer)
}