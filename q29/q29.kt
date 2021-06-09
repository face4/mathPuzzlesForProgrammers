package q29

import kotlin.math.abs

const val golden = 1.6180339887

fun main() {
    val values = MutableList(11) { mutableListOf(1.0) }
    for (i in 2..10) {
        values[i] = values[i - 1].map { it + 1.0 }.toMutableList()
        for (j in 1 until (1 shl (i - 1))) {
            var splits = mutableListOf<Int>()
            var now = 1
            for (k in 0 until i - 1) {
                if (j and (1 shl k) > 0) {
                    splits.add(now)
                    now = 1
                } else {
                    now++
                }
            }
            splits.add(now)
            val comb = splits.map { values[it] }.fold(listOf(0.0)) { acc, list ->
                acc.map { a -> list.map { a + 1.0 / it } }.flatten().map { 1 / it }
            }
            values[i] += comb
        }
    }
    println(values.flatten().minByOrNull { abs(golden - it) })
}