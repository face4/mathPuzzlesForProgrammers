package q27

import kotlin.math.min

fun main() {
    val h = 4
    val w = 6
    val yoko = List(h + 1) { MutableList(w) { false } }
    val tate = List(h) { MutableList(w + 1) { false } }

    val di = listOf(0, 1, 0, -1)
    val dj = listOf(1, 0, -1, 0)

    var answer = 0

    fun dfs(dir: Int, i: Int, j: Int) {
        if (i == h && j == w) {
            answer++
            return
        }
        if (dir % 2 == 0) {
            val nj = j + dj[dir]
            if (nj in 0..w && !yoko[i][j + min(0, dj[dir])]) {
                yoko[i][j + min(0, dj[dir])] = true
                dfs(dir, i, nj)
                yoko[i][j + min(0, dj[dir])] = false
            }
            val ndir = (dir + 1) % 4
            val ni = i + di[ndir]
            if (ni in 0..h && !tate[i + min(0, di[ndir])][j]) {
                tate[i + min(0, di[ndir])][j] = true
                dfs(ndir, ni, j)
                tate[i + min(0, di[ndir])][j] = false
            }
        } else {
            val ni = i + di[dir]
            if (ni in 0..h && !tate[i + min(0, di[dir])][j]) {
                tate[i + min(0, di[dir])][j] = true
                dfs(dir, ni, j)
                tate[i + min(0, di[dir])][j] = false
            }
            val ndir = (dir + 1) % 4
            val nj = j + dj[ndir]
            if (nj in 0..w && !yoko[i][j + min(0, dj[ndir])]) {
                yoko[i][j + min(0, dj[ndir])] = true
                dfs(ndir, i, nj)
                yoko[i][j + min(0, dj[ndir])] = false
            }
        }
    }

    yoko[0][0] = true
    dfs(0, 0, 1)
    println(answer)
}