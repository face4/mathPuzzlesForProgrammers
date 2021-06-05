fun main() {
    val table = MutableList(25) { MutableList(25) { false } }
    table[12][12] = true
    table[12][11] = true
    val di = listOf(0, 0, 1, -1)
    val dj = listOf(-1, 1, 0, 0)

    fun rec(residual: Int, posi: Int, posj: Int): Int {
        if (residual == 0) {
            return 1
        }
        var ret = 0
        for (k in 0 until 4) {
            val ni = posi + di[k]
            val nj = posj + dj[k]
            if (table[ni][nj]) continue
            table[ni][nj] = true
            ret += rec(residual - 1, ni, nj)
            table[ni][nj] = false
        }
        return ret
    }

    println(4 * rec(11, 12, 11))
}