import kotlinx.coroutines.*

//"Cancellation is cooperative" kavramı,Kotlin coroutines'te iptal işleminin işbirliği gerektiren bir süreç olduğunu ifade eder. Yani, bir coroutine iptal edilmek istendiğinde, ilgili coroutine'in iptal isteğini algılayıp uygun adımları atması gerekmektedir. İptal işlemi, coroutine içinde yer alan kod bloklarının belirli noktalarda iptal durumunu kontrol etmesine dayanır.
//
//Bu yaklaşım, iptal işlemini daha kontrollü hale getirir ve iptal işlemlerinin öngörülebilir bir şekilde gerçekleşmesini sağlar. Coroutine iptal edildiğinde, iptal durumunu kontrol eden kod blokları, çalışmayı durdurabilir, temizlik işlemlerini yapabilir veya gerekli işlemleri gerçekleştirebilir.
//
//Coroutine'ler iptal edilebilir yapılar olduğu için, iptal işlemini takip eden kod bloklarında "isActive" iptal durumu kontrol fonksiyonu kullanılır. Bu fonksiyon, coroutine'in iptal edilip edilmediğini kontrol etmek için kullanılır. Coroutine, iptal edildiğinde bu kontrol fonksiyonu false değerini döndürür ve bu noktada coroutine, iptal işlemini takip eden adımları gerçekleştirir.
//
//İşbirliği gerektiren iptal, coroutine'lerin iptal isteğini düzenli olarak kontrol etmesini ve iptal durumunu takip eden kod bloklarında uygun aksiyonları gerçekleştirmesini gerektirir. Bu sayede, iptal işlemleri daha kontrol edilebilir ve güvenli bir şekilde gerçekleştirilebilir.



//Alttaki kod parçacığını incelediğimizde, coroutine job'unu durdurmak istediğimizde durmadığını fark edeceğiz.
/*fun main() = runBlocking {
    val startTime = System.currentTimeMillis()
val job = launch(Dispatchers.Default) {
    var nextPrintTime = startTime
    var i = 0
    while (i < 5) { // computation loop, just wastes CPU
        // print a message twice a second
        if (System.currentTimeMillis() >= nextPrintTime) {
            println("job: I'm sleeping ${i++} ...")
            nextPrintTime += 500L
        }
    }
}
delay(1300L) // delay a bit
println("main: I'm tired of waiting!")
job.cancelAndJoin() // cancels the job and waits for its completion
println("main: Now I can quit.")
}*/


//"isActive" ile bir yapı kurduğumuzda coroutine job'unun durduğunu fark edeceğiz.
fun main() = runBlocking {
    val startTime = System.currentTimeMillis()
    val job = launch(Dispatchers.Default) {
        var nextPrintTime = startTime
        var i = 0
        while (isActive) { // cancellable computation loop
            // print a message twice a second
            if (System.currentTimeMillis() >= nextPrintTime) {
                println("job: I'm sleeping ${i++} ...")
                nextPrintTime += 500L
            }
        }
    }
    delay(1300L) // delay a bit
    println("main: I'm tired of waiting!")
    job.cancelAndJoin() // cancels the job and waits for its completion
    println("main: Now I can quit.")
}
