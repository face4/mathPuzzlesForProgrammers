package q12

import kotlin.math.sqrt

// 問題文が厳密じゃないと思う
fun main() {
    var num = 1

    // 整数を含む
    while (true) {
        val f = sqrt(num.toDouble()).toString()
        if (f.toCharArray().filter { it != '.' }.take(10).distinct().size == 10) {
            println("整数を含む場合 : $num ($f)")
            break
        }
        num++
    }

    // 整数を含まない
    num = 1
    while (true) {
        val f = sqrt(num.toDouble()).toString()
        if (f.toCharArray().let {
                it.drop(1 + it.indexOfFirst { c -> c == '.' })
            }.take(10).distinct().size == 10){
            println("整数を含まない場合 : $num ($f)")
            break
        }
        num++
    }
}