package com.example.up2date

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setTitle("up2date")

        val bottomNav = findViewById<BottomNavigationView>(R.id.bottomNavigation)

        bottomNav.setOnNavigationItemSelectedListener {
            prefs.preferences.edit()
                .putInt("nav", it.itemId)
                .apply()

            when(it.itemId) {
                R.id.action_fragment1 -> {
                    pushFragment(HomeFragment()); true
                }
                R.id.action_fragment2 -> {
                    pushFragment(FilterFragment()); true
                }
                R.id.action_fragment3 -> {
                    pushFragment(SavedFragment()); true
                }
                else -> false
            }

        }

        bottomNav.selectedItemId = prefs.preferences.getInt("nav", R.id.action_fragment1)
    }

    private fun pushFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, fragment)
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
            .commit()
    }

    private val prefs by lazy { Prefs(this, PREFS_NAME = "preferences")  }
}