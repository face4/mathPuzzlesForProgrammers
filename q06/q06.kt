fun main() {
    var answers = mutableListOf<Int>()
    for (i in 2..10000 step 2) {
        val history = mutableSetOf(i)
        var now = i * 3 + 1
        while (now !in history) {
            history.add(now)
            now = if (now % 2 == 1) now * 3 + 1 else now / 2
        }
        if (now == i) {
            answers.add(i)
        }
    }
    println(answers.size)
}