package sjsu.cmpe277.Assignment2.Network

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.amdroid_main.weather_fragment.*
import sjsu.cmpe277.myandroidmulti.R
import sjsu.cmpe277.myandroidmulti.databinding.WeatherFragmentBinding


//import sun.invoke.util.VerifyAccess.getPackageName


class WeatherFragment : Fragment() {

//    companion object {
//        fun newInstance() = WeatherFragment()
//    }

    private lateinit var viewModel: WeatherViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = DataBindingUtil.inflate<WeatherFragmentBinding>(inflater, R.layout.weather_fragment,container,false)
        //viewModel = ViewModelProviders.of(this).get(QuestionViewModel::class.java)
        viewModel = ViewModelProviders.of(this).get(WeatherViewModel::class.java)

        viewModel.app_resp.observe(viewLifecycleOwner, Observer { newresponse ->
            binding.weathertextView.text = newresponse.toString() //display the raw json data
        })
        viewModel.appIcon.observe(viewLifecycleOwner, Observer { newresponse ->
            val appIcon = newresponse.toString();
            val image_uri ="@drawable/a$appIcon"; // where myresource (without the extension) is the file
            val img_res =
                resources.getIdentifier(image_uri, null, context?.packageName)
            //weatherimage.setimg_res(R.drawable.a02d);
            weatherimage.setimg_res(img_res);
        })
        viewModel.weather_temp.observe(viewLifecycleOwner, Observer { newresponse ->
            binding.weatherTempView.text = newresponse.toString() //display the raw json data
        })
        viewModel.City_weather.observe(viewLifecycleOwner, Observer { newresponse ->
            binding.citytextView.text = newresponse.toString() //display the raw json data
        })
        viewModel.Min Temp.observe(viewLifecycleOwner, Observer { newresponse ->
            binding.weatherMin TempView.text = newresponse.toString() //display the raw json data
        })
        viewModel.feelslike.observe(viewLifecycleOwner, Observer { newresponse ->
            binding.feelslikeView.text = newresponse.toString() //display the raw json data
        })
        viewModel.Wind_speed.observe(viewLifecycleOwner, Observer { newresponse ->
            binding.Wind_speedView.text = newresponse.toString() //display the raw json data
        })
        viewModel.pressure.observe(viewLifecycleOwner, Observer { newresponse ->
            binding.pressureView.text = newresponse.toString() //display the raw json data
        })
        viewModel.Humidity.observe(viewLifecycleOwner, Observer { newresponse ->
            binding.HumidityView.text = newresponse.toString() //display the raw json data
        })
        viewModel.sunrise_time.observe(viewLifecycleOwner, Observer { newresponse ->
            binding.sunrise_timeView.text = newresponse.toString() //display the raw json data
        })
        viewModel.sunset_time.observe(viewLifecycleOwner, Observer { newresponse ->
            binding.sunset_timeView.text = newresponse.toString() //display the raw json data
        })

        return binding.root//inflater.inflate(R.layout.weather_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(WeatherViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
