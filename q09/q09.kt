fun main() {
    fun rec(status: Int, men: Int, women: Int): Int{
        if(men+women == 1){
            return 1
        }
        var ret = 0
        if(men > 0 && status != -1 && men-1 != women){
            ret += rec(status+1, men-1, women)
        }
        if(women > 0 && status != 1 && men != women-1){
            ret += rec(status-1, men, women-1)
        }
        return ret
    }

    println(rec(0, 20, 10))

    fun solve(men: Int, women: Int): Int{
        val dp = List(men+1){MutableList(women+1){0} }
        dp[0][0] = 1
        for(i in 0..men){
            for(j in 0..women){
                if(i == j || men-i==women-j)    continue
                if(i > 0)   dp[i][j] += dp[i-1][j]
                if(j > 0)   dp[i][j] += dp[i][j-1]
            }
        }
        return dp[men-1][women]+dp[men][women-1]
    }

    println(solve(20, 10))
}