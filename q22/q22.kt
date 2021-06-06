package q22

fun main() {
    val dp = MutableList(17) { 0 }
    dp[0] = 1
    for (i in 2..16 step 2) {
        for (j in 0..(i - 2) step 2) {
            dp[i] += dp[i - 2 - j] * dp[j]
        }
    }
    println(dp[16])
}