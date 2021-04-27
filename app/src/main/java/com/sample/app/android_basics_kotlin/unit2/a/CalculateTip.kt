package com.sample.app.android_basics_kotlin.unit2.a

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sample.app.android_basics_kotlin.R
import com.sample.app.android_basics_kotlin.databinding.ActivityCalculateTipBinding
import java.text.NumberFormat

/**
 * 對應內容:
 * Get user input in an app: Part 1
 * https://developer.android.com/courses/pathways/android-basics-kotlin-unit-2-pathway-1
 * 練習目的：
 * 1. 範例：計算小費
 * 練習重點：
 * 了解建立layout與操作方法(xml格式)
 * 了解繼承 抽象等
 * 使用ViewBinding 進行操作
 * editText 取值與轉換
 * RadioButton
 * Switch
 * --
 * 額外補足:
 * 該程式建立途中會遇到未填寫edittext時執行動作產生閃退所需的偵錯內容等
 * 練習部分:
 * 建立一個計算機 可以單位換算等等內容
 **/
class CalculateTip : AppCompatActivity() {

    lateinit var binding: ActivityCalculateTipBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //  setContentView(R.layout.activity_calculate_tip) //
        binding = ActivityCalculateTipBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.calculateButton.setOnClickListener { calculateTip() }
        binding.tipResult.text = ""
    }

    private fun calculateTip() {
        val stringInTextField = binding.costOfService.text.toString()
        val cost = stringInTextField.toDoubleOrNull()
        if (cost == null) {
            binding.tipResult.text = ""
            return
        }
        val tipPercentage = when (binding.tipOptions.checkedRadioButtonId) {
            R.id.option_twenty_percent -> 0.20
            R.id.option_eighteen_percent -> 0.18
            else -> 0.15
        }
        var tip = tipPercentage * cost
        if (binding.roundUpSwitch.isChecked) {
            tip = kotlin.math.ceil(tip)
        }
        val formattedTip = NumberFormat.getCurrencyInstance().format(tip)
        binding.tipResult.text = getString(R.string.tip_amount, formattedTip)
    }
}

