package Myapp.weather;
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.Deferred
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshappIconverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

private const val BASE_URL = "https://api.openweathermap.org"//



private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()


//private val retrofit = Retrofit.Builder()
//    .addConverterFactory(ScalarsConverterFactory.create()) //Retrofit has a ScalarsConverter that supports strings and other primitive types
//    .baseUrl(BASE_URL)
//    .build() //create the Retrofit object.

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshappIconverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()



interface WeatherApiService {
    @GET("/data/2.5/weather") //realestate Retrofit appends the endpoint to the base URL
    fun getProperties(@Query("q") city: String, @Query("appid") apiKey: String):
            Call<WeatherProperty> //List<WeatherProperty>
    //Call<String>
//    fun getProperties():
//            Call<String>
}


object WeatherApi {
    val retrofitService : WeatherApiService by lazy {
        retrofit.create(WeatherApiService::class.java) }
    //The Retrofit create() method creates the Retrofit service itself with the ApiService interface.
}
