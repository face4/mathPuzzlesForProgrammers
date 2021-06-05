package q10

import kotlin.math.max

class Roulette(private val list: List<Int>) {
    fun sumMax(n: Int): Int {
        var ret = list.subList(0, n).sum()
        var tmp = ret
        for (i in list.indices) {
            tmp = tmp - list[i] + list[(i + n) % list.size]
            ret = max(ret, tmp)
        }
        return ret
    }
}

fun main() {
    val europe = Roulette(listOf(0,32,15,19,4,21,2,25,17,34,6,27,13,36,11,30,8,23,10,5,24,16,33,1,20,14,31,9,22,18,29,7,28,12,35,3,26))
    val america = Roulette(listOf(0,28,9,26,30,11,7,20,32,17,5,22,34,15,3,24,36,13,1,0,27,10,25,29,12,8,19,31,18,6,21,33,16,4,23,35,14,2))
    var answer = 0
    for(n in 2..36){
        if(europe.sumMax(n) < america.sumMax(n)){
            answer++
        }
    }
    println(answer)
}