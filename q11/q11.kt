package q11

fun main() {
    var a = 89L
    var b = 144L
    var answer = mutableListOf<Long>()
    while (answer.size < 5) {
        var c = a + b
        if (c % c.toString().toCharArray().sumOf { it - '0' } == 0L) {
            answer.add(c)
        }
        a = b
        b = c
    }
    println(answer)
}