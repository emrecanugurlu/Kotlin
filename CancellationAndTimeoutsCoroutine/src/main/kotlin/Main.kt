import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

//Bazen oluşturduğumuz coroutine'leri iptal etmek isteyebiliriz, bu durumlarda job.cancel() metodunu kullanmalıyız. Bunun dışında job.cancelAndJoin() metodu da bulunmaktadır bu ise coroutine'yi iptal eder ve iptal işlemi tamamlanana kadar bekler.

fun main(args: Array<String>) = runBlocking() {
    val job = launch {
        repeat(5000){
            println(it)
            delay(500)
        }
    }
    delay(1300)
    println("main: I'm tired of waiting!")
    //Coroutine'i iptal eder ve iptal işlemi tamamlanana kadar bekler.
    job.cancelAndJoin()
    println("main: Now I can quit.")
}