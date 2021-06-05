fun main() {
    for (i in 1000..9999) {
        val istr = i.toString()
        for (j in 1 until (1 shl 3)) {
            val term = mutableListOf<Int>()
            var tmp = 0
            for (k in 0 until 4) {
                tmp = tmp * 10 + (istr[k] - '0')
                if ((j and (1 shl k)) > 0) {
                    term.add(tmp)
                    tmp = 0
                }
            }
            term.add(tmp)
            val prod = term.fold(1) { acc, value -> acc * value }
            if (prod.toString() == istr.reversed()) {
                println("${term.joinToString("*")} = $prod")
            }
        }
    }
}