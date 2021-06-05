package q13

fun main() {
    val strings = listOf("READ", "WRITE", "TALK", "SKILL")
    val signs = listOf(1, 1, 1, -1)
    val ngs = strings.map { it[0] }

    var kiyo = mutableMapOf<Char, Int>()
    for (i in strings.indices) {
        var ten = 1
        val string = strings[i]
        val n = string.length
        for (j in string.indices) {
            kiyo[string[n - 1 - j]] = (kiyo[string[n - 1 - j]] ?: 0) + signs[i] * ten
            ten *= 10
        }
    }

    var answer = 0

    var perm = mutableListOf<Int>()
    fun rec() {
        if (perm.size == 10) {
            var leadingZero = false
            var index = 0
            var sum = 0
            for ((char, int) in kiyo) {
                if (char in ngs && perm[index] == 0) {
                    leadingZero = true
                }
                sum += int * perm[index]
                index++
            }
            if (sum == 0 && !leadingZero) answer++
        }
        for (i in 0..9) {
            if (i in perm) continue
            perm.add(i)
            rec()
            perm.removeLast()
        }
    }

    rec()

    println(answer)
}