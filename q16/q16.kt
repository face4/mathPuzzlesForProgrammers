package q16

data class Tuple(val a: Int, val b: Int, val c: Int)

fun gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)

fun main() {
    var answer = mutableListOf<Tuple>()
    for (i in 4..500 step 4) {
        val c = i / 4
        for (a in 1 until c) {
            for (b in a until c) {
                if (a * a + b * b == c * c && gcd(a, b) == 1) {
                    answer.add(Tuple(a, b, c))
                }
            }
        }
    }
    println(answer.size)
    println(answer.joinToString("\n"))
}