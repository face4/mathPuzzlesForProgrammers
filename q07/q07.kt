package q07

data class Date(val y: Int, val m: Int, val d: Int) {
    companion object {
        val days = listOf(0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31)

        fun pad(value: Int) = (if (value < 10) "0" else "") + value
    }

    private val isLeap: Boolean
        get() = y % 4 == 0 && !(y % 100 == 0 && y % 400 != 0)

    private val isLastDayOfMonth: Boolean
        get() = if (m != 2) {
            days[m] == d
        } else {
            days[m] + (if (isLeap) 1 else 0) == d
        }

    val number: Int = y * 10000 + m * 100 + d

    fun nextDate(): Date {
        var (ny, nm, nd) = this
        if (isLastDayOfMonth) {
            if (nm == 12) {
                ny++
                nm = 1
            } else {
                nm++
            }
            nd = 1
        } else {
            nd++
        }
        return Date(ny, nm, nd)
    }

    override fun toString() = "$y/${pad(m)}/${pad(d)}"
}

fun toDate(x: Int): Date {
    return Date(x / 10000, x % 10000 / 100, x % 100)
}

fun main() {
    var from = Date(1964, 10, 10)
    val to = Date(2020, 7, 24)
    while (from != to) {
        if (from == toDate(from.number.toString(2).reversed().toInt(2))) {
            println(from)
        }
        from = from.nextDate()
    }
}