package com.syed.walmartproject.presentation.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.syed.walmartproject.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            val countryFragment = CountryFragment()
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, countryFragment).commit()
        }
    }
}

