import kotlinx.coroutines.*
import kotlinx.coroutines.flow.flow
import model.Post
import retrofit2.Response
import service.RetrofitBuilder

suspend fun main(){
    getData().collect{
        println(it)
    }
}

fun getData() = flow {
    val retrofit = RetrofitBuilder.getRetrofitBuilder()
    val service = retrofit.create(JsonPlaceholderApi::class.java)
    val post = service.getData()
    emit(post.body())
}







            /*runBlocking {
                val retrofit = RetrofitBuilder.getRetrofitBuilder()
                val service = retrofit.create(JsonPlaceholderApi::class.java)
                val post = async {
                    service.getData()
                }
                println("a")
                val posts = post.await()
                println(posts.body()?.get(0))
            }
    println("Program sonlandı")*/


