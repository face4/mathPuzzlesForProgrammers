import kotlin.math.min

fun solve(n: Int, m: Int): Int {
    var pieces = listOf(n)
    var step = 0
    while (pieces.isNotEmpty()) {
        val next = mutableListOf<Int>()
        for (i in 0 until min(m, pieces.size)) {
            next.add(pieces[i] / 2)
            next.add(pieces[i] - pieces[i] / 2)
        }
        if (m < pieces.size) {
            next.addAll(pieces.subList(m, pieces.size))
        }
        pieces = next.filter { it > 1 }.sortedDescending()
        step++
    }
    return step
}

fun solve2(n: Int, m: Int, current: Int): Int{
    return if(n <= current){
        0
    }else if(current < m){
        1 + solve2(n, m, current*2)
    }else{
        1 + solve2(n, m, current+m)
    }
}

fun main() {
    println("n =  20, m = 3 : ${solve(20, 3)}, ${solve2(20, 3, 1)}")
    println("n = 100, m = 5 : ${solve(100, 5)}, ${solve2(100, 5, 1)}")
}