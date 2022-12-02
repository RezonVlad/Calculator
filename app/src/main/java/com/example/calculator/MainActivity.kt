package com.example.calculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import com.example.calculator.databinding.ActivityMainBinding
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        supportActionBar?.hide();

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bt0.setOnClickListener { setTextFields("0") }
        binding.bt1.setOnClickListener { setTextFields("1") }
        binding.bt2.setOnClickListener { setTextFields("2") }
        binding.bt3.setOnClickListener { setTextFields("3") }
        binding.bt4.setOnClickListener { setTextFields("4") }
        binding.bt5.setOnClickListener { setTextFields("5") }
        binding.bt6.setOnClickListener { setTextFields("6") }
        binding.bt7.setOnClickListener { setTextFields("7") }
        binding.bt8.setOnClickListener { setTextFields("8") }
        binding.bt9.setOnClickListener { setTextFields("9") }
        binding.miBt.setOnClickListener { setTextFields("-") }
        binding.plBt.setOnClickListener { setTextFields("+") }
        binding.slashBt.setOnClickListener { setTextFields("/") }
        binding.muBt.setOnClickListener { setTextFields("*") }

        binding.clearBtn.setOnClickListener {
            binding.mathOperation.text = ""
        }

        binding.baBt.setOnClickListener {
            var str = binding.mathOperation.text.toString()
            if(str.isNotEmpty())
                binding.mathOperation.text = str.substring(0, str.length - 1)

        }

        binding.equalBtn.setOnClickListener {
                val intent = Intent(this, MainActivity2::class.java)
                var ex = ExpressionBuilder(binding.mathOperation.text.toString()).build()
                var result = ex.evaluate()
                print("$result")

                var longRes = result.toLong()
                if(result == longRes.toDouble()){
                    intent.putExtra("Результат", longRes.toString());
                    startActivity(intent)
                }
        }
    }

    fun setTextFields(str: String){
        binding.mathOperation.append(str)
    }
}