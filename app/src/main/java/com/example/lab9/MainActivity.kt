package com.example.lab9

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.Window
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.appbar.MaterialToolbar

class MainActivity : AppCompatActivity() {

    private lateinit var bar: MaterialToolbar
    private lateinit var control: NavController


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.activity_main)

        val navHFragment = supportFragmentManager.findFragmentById(R.id.myFragmentContainerView) as NavHostFragment

        control = navHFragment.navController

        val configurarBar = AppBarConfiguration(control.graph)
        bar = findViewById(R.id.myToolBar)
        bar.setupWithNavController(control,configurarBar)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_toolbar,menu)
        return true
    }

}