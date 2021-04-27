package com.sample.app.android_basics_kotlin.unit2.b

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import com.sample.app.android_basics_kotlin.R
import com.sample.app.android_basics_kotlin.databinding.ActivityCalculateTipBinding
import com.sample.app.android_basics_kotlin.databinding.ActivityUserExperienceBinding
import java.text.NumberFormat

/**
 * 該內容為
 * Get user input in an app: Part 1的衍生修改
 * 所以將會複製該內容的程式碼做更動 以作區別
 *
 * 對應內容:
 * Get user input in an app: Part 2
 * https://developer.android.com/courses/pathways/android-basics-kotlin-unit-2-pathway-2
 *
 * 官方sample :
 * 主題變色 - https://github.com/material-components/material-components-android-examples
 * 更換主題內容 - https://github.com/google-developer-training/android-basics-kotlin-tip-calculator-app-solution
 *
 * 練習目的：
 * 1. 改變主題顏色
 * 2. 黑暗主題的變更方式與設定（需要api28 android9.0以上裝置)
 * 3. 更換app icon
 * 4. 處理旋轉螢幕時會發生的事件
 *
 * 練習重點：
 * 設定主題顏色時 必須設定theme與night/theme來達到主題變色與黑暗模式的兩種狀態
 * 了解材料庫以配合現在較為流行的設計樣式
 * 使用者體驗與操作流程上的內容詳細
 * 向量圖片的引用與操作
 * --
 * 額外補足:
 * 官方提供的 Material Components - https://material.io/components
 *
 * 練習部分:
 *
 **/
class UserExperience : AppCompatActivity() {

    lateinit var binding: ActivityUserExperienceBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_TipTime) // 這行設定theme
        //  setContentView(R.layout.activity_calculate_tip) //
        binding = ActivityUserExperienceBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.calculateButton.setOnClickListener { calculateTip() }
        binding.tipResult.text = ""
        binding.costOfServiceEditText.setOnKeyListener { view, keyCode, _ -> handleKeyEvent(view, keyCode)
        }
    }

    private fun calculateTip() {
        val stringInTextField = binding.costOfServiceEditText.text.toString()
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

    private fun handleKeyEvent(view: View, keyCode: Int): Boolean {
        if (keyCode == KeyEvent.KEYCODE_ENTER) {
            // Hide the keyboard
            val inputMethodManager =
                getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
            return true
        }
        return false
    }
}