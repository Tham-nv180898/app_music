package com.example.myapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.example.myapp.R
import com.example.myapp.ui.home.HomeFragment
import com.example.myapp.ui.music.MusicFragment
import com.example.myapp.ui.search.SearchFragment
import com.example.myapp.ui.settings.SettingsFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(),
    BottomNavigationView.OnNavigationItemSelectedListener {
    private lateinit var bottomNavigationView: BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
        initBottomNavigationView()
    }

    private fun initView() {
        bottomNavigationView = findViewById(R.id.bottom_navigation_view)
    }

    private fun initBottomNavigationView() {
        bottomNavigationView.apply {
            setOnNavigationItemSelectedListener(this@MainActivity)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        if (item.itemId == bottomNavigationView.selectedItemId) {
            return false
        }
        showFragment(item.itemId)
        return true
    }

    private fun showFragment(itemId: Int) {
        val fragment = when (itemId) {
            R.id.item_home -> HomeFragment()
            R.id.item_music -> MusicFragment()
            R.id.item_search -> SearchFragment()
            R.id.item_settings -> SettingsFragment()
            else -> null
        }
        fragment?.apply(::replaceFragment)
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.layout_fragment_container, fragment)
            .setReorderingAllowed(true)
            .commit()
    }
}