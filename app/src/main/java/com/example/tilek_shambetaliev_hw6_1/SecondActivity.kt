package com.example.tilek_shambetaliev_hw6_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.tilek_shambetaliev_hw6_1.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.etFindNumber.setText(intent.getStringExtra(MainActivity.MASATEXT))

        binding.btnFindNumber.setOnClickListener {
            val intent = Intent()
            intent.putExtra(MainActivity.MASATEXT, binding.etFindNumber.text.toString())
            setResult(RESULT_OK, intent)
            finish()
        }
    }
}