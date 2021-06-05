fun main() {
    val ura = MutableList(101){true}
    for(i in 2..100){
        for(j in i..100 step i){
            ura[j] = !ura[j]
        }
    }
    for(i in 1..100){
        if(ura[i])  println(i)
    }
}