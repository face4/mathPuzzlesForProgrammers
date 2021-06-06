package q14

import java.util.*

fun main() {
    val countries = listOf(
        "Brazil", "Croatia", "Mexico", "Cameroon",
        "Spain", "Netherlands", "Chile", "Australia",
        "Colombia", "Greece", "Cote d'Ivoire", "Japan",
        "Uruguay", "Costa Rica", "England", "Italy",
        "Switzerland", "Ecuador", "France", "Honduras",
        "Argentina", "Bosnia and Herzegovina", "Iran",
        "Nigeria", "Germany", "Portugal", "Ghana",
        "USA", "Belgium", "Algeria", "Russia",
        "Korea Republic"
    ).map { it.uppercase(Locale.getDefault()) }

    var answer = listOf<String>()
    var tmp = mutableListOf<String>()

    fun rec() {
        for (country in countries) {
            if (country in tmp) continue
            if (tmp.last().last() != country[0]) continue
            tmp.add(country)
            if (tmp.size > answer.size){
                answer = tmp.map{it}
            }
            rec()
            tmp.remove(country)
        }
    }

    for (country in countries) {
        tmp.add(country)
        rec()
        tmp.remove(country)
    }

    println("${answer.size} $answer")
}