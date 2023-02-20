package com.example.figma

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.figma.data.Pref
import com.example.figma.databinding.ActivityMainBinding
import com.example.figma.databinding.FragmentAcceptBinding
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var pref: Pref
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        pref = Pref(this)
        auth = FirebaseAuth.getInstance()

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.

        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_favorites, R.id.navigation_add,
                R.id.navigation_message,
                R.id.navigation_profile,
                R.id.getStartFragment,
                R.id.signInFragment,
                R.id.acceptFragment
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
        val bottomNavFragment = arrayListOf(
            R.id.navigation_home,
            R.id.navigation_favorites,
            R.id.navigation_add,
            R.id.navigation_message,
            R.id.navigation_profile
        )
        navController.addOnDestinationChangedListener { controller, destination, arguments ->
            navView.isVisible = bottomNavFragment.contains(destination.id)
            if (destination.id == R.id.getStartFragment || destination.id == R.id.signInFragment|| destination.id == R.id.acceptFragment) {
                supportActionBar?.hide()
            } else supportActionBar?.show()
        }
    }
}