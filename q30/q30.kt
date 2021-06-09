package q30

fun main() {
    val memo = MutableList(21) { 0L }
    memo[1] = 1

    fun dfs(x: Int): Long {
        if (memo[x] != 0L) {
            return memo[x]
        }

        // 2口
        for (i in 1..x / 2) {
            val j = x - i
            if (i == j) {
                // C(2+dfs(i)-1, 2) 仕切りをいれる例のアレ
                memo[x] += dfs(i) * (dfs(i) + 1) / 2
            } else {
                memo[x] += dfs(i) * dfs(j)
            }
        }

        // 3口
        for (i in 1..x / 3) {
            for (j in i..(x - i) / 2) {
                var k = x - i - j
                val bef = memo[x]
                if (i == j && j == k) {
                    // C(3+dfs(i)-1, 2)
                    memo[x] += dfs(i) * (dfs(i) + 1) * (dfs(i) + 2) / 6
                } else if (i == j) {
                    memo[x] += dfs(k) * (dfs(i) * (dfs(i) + 1) / 2)
                } else if (j == k) {
                    memo[x] += dfs(i) * (dfs(j) * (dfs(j) + 1) / 2)
                } else {
                    memo[x] += dfs(i) * dfs(j) * dfs(k)
                }
            }
        }
        return memo[x]
    }

    println(dfs(20))
}