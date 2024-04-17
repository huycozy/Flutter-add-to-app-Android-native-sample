package com.example.addtoapp_androidnative

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.fragment.app.FragmentActivity
import com.example.addtoapp_androidnative.databinding.ActivityMainBinding
import io.flutter.embedding.android.FlutterFragment

class MainActivity : FragmentActivity() {
    private val TAG_FLUTTER_FRAGMENT = "flutter_fragment"
    private lateinit var binding: ActivityMainBinding
    private var flutterFragment: FlutterFragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Get a reference to the Activity's FragmentManager to add a new
        // FlutterFragment, or find an existing one.

        // Get a reference to the Activity's FragmentManager to add a new
        // FlutterFragment, or find an existing one.
        val fragmentManager = supportFragmentManager

        // Attempt to find an existing FlutterFragment,
        // in case this is not the first time that onCreate() was run.

        // Attempt to find an existing FlutterFragment,
        // in case this is not the first time that onCreate() was run.
        flutterFragment = fragmentManager
            .findFragmentByTag(TAG_FLUTTER_FRAGMENT) as FlutterFragment?

        // Create and attach a FlutterFragment if one does not exist.

        // Create and attach a FlutterFragment if one does not exist.
        if (flutterFragment == null) {

            // No leaks with createDefault
            //flutterFragment = FlutterFragment.createDefault();

            // Leaks with cached engine
            flutterFragment = FlutterFragment.withCachedEngine("my_engine_id").build()
            fragmentManager
                .beginTransaction()
                .add(binding.fragmentContainer.id, flutterFragment!!, TAG_FLUTTER_FRAGMENT)
                .commit()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

}