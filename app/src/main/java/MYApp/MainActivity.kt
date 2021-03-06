package sjsu.cmpe277.Assignment2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import androidx.navigation.findNavController //imported from androidx.navigation:navigation-ui-ktx
import sjsu.cmpe277.myandroidmulti.databinding.Activityamdroid_mainBinding


const val KEY_Data = "inputname_key"

class amdroid_mainActivity : AppCompatActivity() {

    private lateinit var navController: NavController
    private lateinit var binding: Activityamdroid_mainBinding
    private lateinit var drawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_amdroid_main)

//        binding = DataBindingUtil.setContentView(this, R.layout.activity_amdroid_main)
//        navController = Navigation.findNavController(this, R.id.myNavHostFragment)
//        NavigationUI.setupActionBarWithNavController(this,navController)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_amdroid_main)
        drawerLayout = binding.drawerLayout

        //navController = findNavController(R.id.myNavHostFragment)

        navController = Navigation.findNavController(this, R.id.myNavHostFragment)
        NavigationUI.setupActionBarWithNavController(this,navController,drawerLayout)


        NavigationUI.setupWithNavController(binding.navView, navController)

        Log.i("amdroid_mainActivity", "onCreate Called")

        if (savedInstanceState != null) {
            var restoredstr = savedInstanceState.getString(KEY_Data, "").toString()
            Log.i("amdroid_mainActivity", restoredstr)
        }



    }

    override fun onStart() {
        super.onStart()
        Log.i("amdroid_mainActivity", "onStart Called")
    }

//    override fun onSupportNavigateUp(): Boolean {
//        navController = Navigation.findNavController(this, R.id.myNavHostFragment)
//        return navController.navigateUp(navController)
//    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = Navigation.findNavController(this, R.id.myNavHostFragment)
        return NavigationUI.navigateUp(navController, drawerLayout)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        Log.i("amdroid_mainActivity", "onSaveInstanceState Called")

        outState.putString(KEY_Data, "test save name")
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        Log.i("amdroid_mainActivity", "onRestoreInstanceState Called")
        if (savedInstanceState != null) {
            var restoredstr = savedInstanceState.getString(KEY_Data, "").toString()
            Log.i("amdroid_mainActivity", "onRestoreInstanceState not null")
        }
    }

}
