package q19

import kotlin.math.min

fun main() {
    val p = listOf(2, 3, 5, 7, 11, 13)
    var n = 13 * 13

    var list = mutableListOf<Int>()
    fun rec() {
        if (list.size == 6) {
            n = min(
                n,
                (list.zipWithNext { a, b -> a * b } + listOf(list[0] * list[0], list.last() * list.last())).maxOrNull()
                    ?: 0)
        } else {
            for (i in p) {
                if (i in list) continue
                list.add(i)
                rec()
                list.removeAt(list.size - 1)
            }
        }
    }

    rec()

    println(n)
}