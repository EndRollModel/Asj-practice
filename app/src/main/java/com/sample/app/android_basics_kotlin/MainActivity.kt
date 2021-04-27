package com.sample.app.android_basics_kotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.sample.app.android_basics_kotlin.databinding.ActivityMainBinding
import com.sample.app.android_basics_kotlin.unit1.a.BasicLayout
import com.sample.app.android_basics_kotlin.unit1.b.AddAButton
import com.sample.app.android_basics_kotlin.unit2.a.CalculateTip
import com.sample.app.android_basics_kotlin.unit2.b.UserExperience

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // 二擇一使用 效果一樣
        viewBinging()
//        findViewById()
    }

    private fun viewBinging(){
        binding.BasicsLayoutButton.setOnClickListener { startActivity(Intent(this, BasicLayout::class.java)) }
        binding.AddButtonButton.setOnClickListener { startActivity(Intent(this, AddAButton::class.java)) }
        binding.CalculateTheTipButton.setOnClickListener { startActivity(Intent(this, CalculateTip::class.java)) }
        binding.UserExperience.setOnClickListener { startActivity(Intent(this, UserExperience::class.java)) }
    }

    private fun findViewById(){
        // 如果沒有使用viewBinding則這樣去呼叫方法
        // lazy宣告按鈕
        basicsLayoutButton.setOnClickListener { startActivity(Intent(this, BasicLayout::class.java)) }
        addButton.setOnClickListener { startActivity(Intent(this, AddAButton::class.java)) }
        calculateButton.setOnClickListener { startActivity(Intent(this, CalculateTip::class.java)) }
        userExperienceButton.setOnClickListener { startActivity(Intent(this, UserExperience::class.java)) }
    }

    private val basicsLayoutButton : Button by lazy {
        findViewById(R.id.BasicsLayoutButton)
    }
    private val addButton : Button by lazy {
        findViewById(R.id.AddButtonButton)
    }
    private val calculateButton : Button by lazy {
        findViewById(R.id.CalculateTheTipButton)
    }
    private val userExperienceButton : Button by lazy {
        findViewById(R.id.UserExperience)
    }
}