package q26

import java.util.*

data class Node(val si: Int, val sj: Int, val ci: Int, val cj: Int)

val di = listOf(-1, 1, 0, 0)
val dj = listOf(0, 0, 1, -1)

fun main() {
    val h = 10
    val w = 10
    val d = mutableMapOf<Node, Int>()
    val queue = LinkedList<Node>()
    val a = Node(h - 1, w, h, w)
    val b = Node(h, w - 1, h, w)
    d[a] = 0
    d[b] = 0
    queue.add(a)
    queue.add(b)
    while (queue.isNotEmpty()) {
        val node = queue.poll()
        for (k in di.indices) {
            val ni = node.si + di[k]
            val nj = node.sj + dj[k]
            if (ni !in 1..10 || nj !in 1..10) {
                continue
            }
            var next = Node(ni, nj, node.ci, node.cj)
            if (ni == node.ci && nj == node.cj) {
                next = Node(node.ci, node.cj, node.si, node.sj)
            }
            if (d.containsKey(next)) continue
            d[next] = 1 + (d[node] ?: 0)
            queue.add(next)
        }
    }
    println(d[Node(h, w, 1, 1)])
}