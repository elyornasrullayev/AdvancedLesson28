package com.ensoft.lesson28

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.ensoft.lesson28.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val viewModel = ViewModelProvider(this)[MainActivityViewModel::class.java]

        viewModel.startTimer()
        viewModel.getTime().observe(this, Observer {
            binding.tvNumber.text = it.toString()
            return@Observer
        })

        viewModel.getTimerStatus().observe(this, Observer {
            binding.tvStatus.text = it.toString()

            if (it)
                Toast.makeText(applicationContext, "Timer tugadi", Toast.LENGTH_SHORT).show()
            return@Observer
        })
        binding.btnCancel.setOnClickListener {
            viewModel.stopTimer()
        }


//        viewModel.setUsername("Live data")
//
//        viewModel.getUsername().observe(this, Observer {
//            binding.tvNumber.text = it
//        })
//
//        Handler().postDelayed({
//                              viewModel.setUsername("shakhzod")
//        },2000)
//
//        Handler().postDelayed({
//            viewModel.setUsername("zo'rkuuuu")
//        },2000)



//        binding.tvNumber.text = viewModel.number.toString()
//        binding.btnIncrement.setOnClickListener {
//            viewModel.increment()
//            binding.tvNumber.text = viewModel.number.toString()
//        }
//
//        binding.btnDecrement.setOnClickListener {
//            viewModel.decrement()
//            binding.tvNumber.text = viewModel.number.toString()
//        }

    }
}