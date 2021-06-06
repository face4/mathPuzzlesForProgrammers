package q21

fun main() {
    var prev = listOf(1, 1)
    var sum = 0
    var dan = 2
    while (sum <= 2014) {
        dan++
        var next = MutableList(dan) { 1 }
        for (i in 1 until dan - 1) {
            next[i] = prev[i] xor prev[i - 1]
        }
        sum += next.count { it == 0 }
        prev = next
    }
    println(dan)
}