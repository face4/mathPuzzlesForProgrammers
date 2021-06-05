val String.isPalindrome: Boolean
    get() = this == this.reversed()

fun main() {
    var answer = 11
    val radixes = listOf(2, 8, 10)
    while (!radixes.all { answer.toString(it).isPalindrome }) {
        answer += 2
    }
    println("dec: $answer\n" +
            "bin: ${answer.toString(2)}\n" +
            "oct: ${answer.toString(8)}"
    )
}