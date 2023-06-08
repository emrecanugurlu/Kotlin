import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

//suspend fonksiyonlar uzun süren işlemlerde (Mesela API'dan veri getirirken) verileri asenkron bir şekilde getirmemizi sağlayan yapılardır. Kotlin Coroutine'ler ile birlikte kullanılırlar.


//Örnek 1
/*fun main(args: Array<String>)  = runBlocking {
    println("Veri Getiriliyor......")
    launch {
        println(getApiData())
    }
}

suspend fun getApiData() : String{
    delay(3000)
    return "Product Name"
}*/


fun main() = runBlocking {
    doWorld()
    println("Done")
}

suspend fun doWorld() = coroutineScope {
    launch {
        delay(2000L)
        println("World 2")
    }
    launch {
        delay(1000L)
        println("World 1")
    }
    delay(5000)
    println("Hello")
}

