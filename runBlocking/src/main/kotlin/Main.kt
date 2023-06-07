import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun main() {

    /*runBlocking işlevi, içindeki kodu senkron bir şekilde çalıştırır ve sonuç alınana kadar bekler. Yani, asenkron işlemler tamamlanana kadar bir sonraki adıma geçmez. Bu, bir senkron işlem gibi davranmasını sağlar ve ardışık bir şekilde işlemleri gerçekleştirmenize olanak tanır. Kotlin Coroutines içinde kullanılan bir yapıdır*/

    //runBlocking içerisindeki işlem bitene kadar bekler ve ardından sonraki işlemlere devam eder.
    runBlocking {
        println("deneme1")
        delay(2000)
        println("deneme2")
    }

    println("deneme3")

}