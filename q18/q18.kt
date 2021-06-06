package q18

import kotlin.system.exitProcess

fun main() {
    var i = 2
    while (true) {
        val sq = (1..i).map { it * it }
        var list = mutableListOf(1)

        fun rec() {
            if (list.size == i && list.last() + list.first() in sq) {
                println("$i $list")
                exitProcess(0)
            }
            for (i in 1..i) {
                if (i in list || list.last() + i !in sq) continue
                list.add(i)
                rec()
                list.removeAt(list.size - 1)
            }
        }

        rec()

        i++
    }
}