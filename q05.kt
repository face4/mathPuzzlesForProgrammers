import kotlin.math.min

fun solve(n: Int, cpos: Int, coins: List<Int>, limit: Int): Int{
    if(cpos == coins.size){
        return if(n == 0) 1 else 0
    }
    var ret = 0
    for(i in 0..min(n/coins[cpos], limit)){
        ret += solve(n-coins[cpos]*i, cpos+1, coins, limit-i)
    }
    return ret
}

fun main() {
    println(solve(1000, 0, listOf(500, 100, 50, 10), 15))
}