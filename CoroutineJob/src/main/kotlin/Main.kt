import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

//Job coroutines'in çalıştığı süreci temsil eden bir yapıdır. Coroutine'in durumunu izlemek ve yönetmek için kullanılır. Coroutine başlatıldığında, bir Job nesnesi döndürülür ve bu nesne üzerinden coroutine'in durumunu takip edebiliriz.

fun main() {
     var job = GlobalScope.launch {
        delay(2000)
        println("productName")
    }

    runBlocking {
        println("Deneme1")
        //Burada join() metodu coroutine'nin işinin bitmesini bekler ondan sonra işlemine devam eder.
        job.join()
        println("Deneme2")
    }
}