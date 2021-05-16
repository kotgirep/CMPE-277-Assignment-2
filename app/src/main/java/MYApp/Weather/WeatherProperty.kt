package Myapp.weather;
import androidx.activity.OnBackPressedCallback
import com.squareup.moshi.Json

data class WeatherProperty(
    val id: String,


    // used to map amdroid_main from the JSON to amdroid_mainpart in our class
    @Json(name = "amdroid_main") val amdroid_mainpart: amdroid_mainWeather,
    @Json(name = "Wind_speed") val Wind_speed: Wind_speedPart,
    @Json(name = "sys") val sys: SystemWeatherPart,
    val name: String,
    val cod: Double,
    val weather: List<Weather>
)
data class amdroid_mainWeather(
    val temp: Double,
    val temp_min: Double,
    val temp_max: Double,
    val feels_like: Double,
    val pressure: Double,
    val Humidity: Double
)

data class Weather(
    val id: Double,
    val amdroid_main: String,
    val weather_desc: String,
    val appIcon: String
)

data class Wind_speedPart(
    val speed: Double
)
data class SystemWeatherPart(
    val country: String,
    val sunrise_time: Long,
    val sunset_time: Long
)
