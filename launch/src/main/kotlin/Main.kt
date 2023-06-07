import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
    // "launch" fonksiyonu, asenkron olarak çalışacak işlevleri veya işlem bloklarını başlatır. İşlev veya blok hemen çalıştırılır ve launch işlevi tamamlanırken sonuç beklemez. Bu sayede, uzun süren veya bloklayıcı işlemleri gerçekleştirirken ana iş parçacığınızın bloke olmasını engelleyebilirsiniz.

        println("deneme1")
        launch {
            delay(2000)
            println("deneme2")
        }
        delay(4000)
        println("deneme3")
    }

    //Çıktıdan da anlayacağımız gibi, launch kumutu kodu bloklamadan(asenkron) bir şekilde işlemlere devam ederken runBlocking kodu bloklayarak(senkron) bir şekilde işlemlerini gerçekleştirir.
}
