package com

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.content.ContextCompat
import com.geeks.counter_mvvm.R
import com.geeks.counter_mvvm.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: ViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initClickers()
        initTv()
        changeTheme()
    }

    private fun initClickers() {
        with(binding) {
            increment.setOnClickListener {
                viewModel.increment()
            }
            decrement.setOnClickListener {
                viewModel.decrement()
            }
            theme.setOnClickListener {
                viewModel.onThemeClick()
            }
        }
    }

    private fun initTv() {
        viewModel.counter.observe(this) {
            binding.counter.text = it.toString()
            if (it == 10){
                Toast.makeText(this, "Поздравляю!", Toast.LENGTH_SHORT).show()
            }
            if (it == 15){
                binding.counter.setTextColor(ContextCompat.getColor(this, R.color.green))
            }
        }
    }

    private fun changeTheme() {
        viewModel.IsDark.observe(this){
            if (it){
                binding.root.setBackgroundColor(ContextCompat.getColor(this@MainActivity, R.color.black
                ))
                binding.counter.setTextColor(ContextCompat.getColor(this@MainActivity, R.color.white
                ))
            }else{
                binding.root.setBackgroundColor(ContextCompat.getColor(this@MainActivity, R.color.white
                ))
                binding.counter.setTextColor(ContextCompat.getColor(this@MainActivity, R.color.black
                ))
            }
        }
    }
}