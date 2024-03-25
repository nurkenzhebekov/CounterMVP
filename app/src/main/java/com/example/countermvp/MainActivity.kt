package com.example.countermvp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.countermvp.counter.ui.CounterFragment
import com.example.countermvp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, CounterFragment()).commit()
        }
    }
}