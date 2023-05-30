package com.example.tilek_shambetaliev_hw6_1

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.example.tilek_shambetaliev_hw6_1.databinding.ActivityMainBinding
import kotlin.random.Random


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val launcher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK && result.data != null) {
                val text = result.data?.getStringExtra(MASATEXT)
                binding.etFindNumber.setText(text)
            }
        }

    // private var randomNumber = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnFindNumber.setOnClickListener {
            if (binding.etFindNumber.text == null) {
                Toast.makeText(this, getString(R.string.toast_oneActivity), Toast.LENGTH_SHORT).show()

            } else {
                val intent = Intent(this, SecondActivity::class.java)
                intent.putExtra(MASATEXT, binding.etFindNumber.text.toString())
                setResult(Activity.RESULT_OK, intent)
                launcher.launch(intent)
            }
        }
    }

    companion object {
const val MASATEXT = "key"
    }
    // binding.btnFindNumber.setOnClickListener {
    //       if (checkPalindrom(binding.etFindNumber.text.toString())) {
    //           Toast.makeText(this, "Поздравляем, вы угадали число", Toast.LENGTH_SHORT).show()
    //       }
    //   }
    // }

    // private fun checkPalindrom(word: String): Boolean {
    //   val words = word.split("")
    // for (i in 0..word.length / 2) {
    //   if (words[i] != words[word.length - i + 1]) {
    //     return false
    //}
    //}
    //return true
    //}

    //  binding.btnFindNumber.setOnClickListener {
    //    val number = binding.etFindNumber.text.toString()
    //     val random = Random.nextInt(1, 11)
    //     if (number.toInt() == random) {
    //          Toast.makeText(this, "Поздравляем, вы угадали число", Toast.LENGTH_SHORT).show()
    //     } else {
    //        Toast.makeText(this, "Вы не угадали, попробуйте еще раз", Toast.LENGTH_SHORT).show()
    //      }
    //  }
}