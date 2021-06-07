package q25

import kotlin.math.max

fun main() {
    var perm = mutableListOf<List<Int>>()
    var list = mutableListOf<Int>()

    fun rec() {
        if (list.size == 5) {
            perm.add(list.map { it })
        } else {
            for (i in 0..4) {
                if (i in list) continue
                list.add(i)
                rec()
                list.removeAt(list.size - 1)
            }
        }
    }

    rec()

    var answer = 0

    for (i in perm.indices) {
        for (j in i + 1 until perm.size) {
            var count = 0
            val llist = perm[i]
            val rlist = perm[j]
            var left = -1
            var right = rlist[0]
            var order = mutableListOf<Pair<Int, Int>>()
            for (k in 0..4) {
                order.add(left to right)
                left = llist[k]
                order.add(left to right)
                if (k < 4) right = rlist[k + 1]
            }
            order.add(left to -1)

            for (k in order.indices) {
                for (l in k + 1 until order.size) {
                    val (a, c) = order[k]
                    val (b, d) = order[l]
                    if ((b - a) * (d - c) < 0) count++
                }
            }

            answer = max(answer, count)
        }
    }

    println(answer)
}