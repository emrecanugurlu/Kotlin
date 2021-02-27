fun main() {
    val deneme: String = "Bu ,bir deneme yazısıdır."
    val denemeList: List<String> = deneme.split(" ").map {
        it.trim()
    }

    denemeList.forEach {
        println(it)
    }
}