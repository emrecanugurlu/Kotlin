import model.Post
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface JsonPlaceholderApi {
    @GET("/posts")
    suspend fun getData(): Response<List<Post>>
}