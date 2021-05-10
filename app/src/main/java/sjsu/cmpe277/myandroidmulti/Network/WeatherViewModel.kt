package sjsu.cmpe277.Assignment2.Network

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.DecimalFormat
import java.text.SimpleDateFormat
import java.util.*

private const val WeatherAPPID = "2b492c001d57cd5499947bd3d3f9c47b"

class WeatherViewModel : ViewModel() {
    // TODO: Implement the ViewModel
    // TODO: Implement the ViewModel
    // The internal MutableLiveData String that stores the most recent response
    val app_resp = MutableLiveData<String>();
    val weather_temp = MutableLiveData<String>();
    val weather_android = MutableLiveData<String>();
    val City_weather = MutableLiveData<String>();
    val mintemp = MutableLiveData<String>();
    val maxtemp = MutableLiveData<String>();
    val pressure = MutableLiveData<String>();
    val Humidity = MutableLiveData<String>();
    val sunrise_time = MutableLiveData<String>();
    val sunset_time = MutableLiveData<String>();
    val Min Temp = MutableLiveData<String>();
    val Max Temp = MutableLiveData<String>();
    val feelslike = MutableLiveData<String>();
    val Wind_speed = MutableLiveData<String>();
    val appIcon = MutableLiveData<String>();


    /**
     * Call getWeatherProperties() on init so we can display status immediately.
     */
    init {
        getWeatherProperties()
    }

    private fun getWeatherProperties() {
        //app_resp.value = "Set the Weather API Response here!"
        //WeatherApi.retrofitService.getProperties()
        WeatherApi.retrofitService.getProperties("San Jose", WeatherAPPID).enqueue(
            object: Callback<WeatherProperty> {
                override fun onFailure(call: Call<WeatherProperty>, t: Throwable) {
                    //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                    app_resp.value = "Failure: " + t.message
                }

                override fun onResponse(call: Call<WeatherProperty>, response: Response<WeatherProperty>) {
                    //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                    val dec = DecimalFormat("#,###.00");
                    app_resp.value = "${response.body()?.weather?.get(0)?.weather_desc}";
                    appIcon.value = "${response.body()?.weather?.get(0)?.appIcon}";
                    City_weather.value = "${response.body()?.name}"

                  // weather_temp in F and Degrees
                    val weather_temp = response.body()?.amdroid_mainpart?.temp;
                    val weather_tempF = (9.0 / 5 * (tempvalue?.minus(273)!!) + 32);
                    val weather_tempD = dec.format(weather_tempF);
                    weather_temp.value = "$weather_tempD °F";

                    val min_temp = response.body()?.amdroid_mainpart?.temp_min;
                    val min_tempF = (9.0 / 5 * (tempvalue?.minus(273)!!) + 32);
                   
                    val min_tempD = dec.format(min_tempF);
                    val max_tempF = (9.0 / 5 * (tempvalue?.minus(273)!!) + 32);
                    val max_temp = response.body()?.amdroid_mainpart?.temp_max;
                    
                    val max_tempD = dec.format(max_tempF);
                    Min Temp.value = "Min Temp $min_tempD °F               Max Temp $max_tempD °F";
                    



                    val feels_like_temprature = response.body()?.amdroid_mainpart?.feels_like;
                    
                    val feels_like_tempratureD = dec.format(feels_like_tempratureF);
                    feelslike.value = "Feels Like $feels_like_tempratureD °F";

                    Wind_speed.value = "Wind_speed Speed \n ${response.body()?.Wind_speed?.speed} m/s";
                    pressure.value = "Pressure ${response.body()?.amdroid_mainpart?.pressure} hPa";
                    Humidity.value = "Humidity \n ${response.body()?.amdroid_mainpart?.Humidity} %";

                    /* sunrise_time.value = "sunrise_time ${java.time.format.DateTimeFormatter.ISO_INSTANT
                        .format(response.body()?.sys?.sunrise_time?.let {
                            java.time.Instant.ofEpochSecond(
                                it
                            )
                        })
                    }";*/
                    sunrise_time.value = "sunrise_time \n ${SimpleDateFormat("hh:mm a", Locale.ENGLISH).format(
                        response.body()?.sys?.sunrise_time?.times(1000)?.let {
                            Date(
                                it
                            )
                        })}";

                    //sunset_time.value = "sunset_time ${response.body()?.sys?.sunset_time}";
                    sunset_time.value = "sunset_time \n ${SimpleDateFormat("hh:mm a", Locale.ENGLISH).format(
                        response.body()?.sys?.sunset_time?.times(1000)?.let {
                            Date(
                                it
                            )
                        })}";


                    //app_resp.value = "Success: ${response.body()?.name} city is retrieved; Temperature: ${response.body()?.amdroid_mainpart?.temp}; Humidity: ${response.body()?.amdroid_mainpart?.Humidity}"
                }

            }
        )
    }
}
