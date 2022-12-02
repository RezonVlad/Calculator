package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.example.calculator.databinding.ActivityMain2Binding


class MainActivity2: AppCompatActivity(){private lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater) //initializing the binding class
        setContentView(binding.root)

        var result = intent.getStringExtra("Результат");

        if (result != null)
            binding.mathResult.text = result

        var display = supportActionBar
        display?.title = "Відповідь"
        display?.setDisplayHomeAsUpEnabled(true)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            android.R.id.home ->{
                finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

}