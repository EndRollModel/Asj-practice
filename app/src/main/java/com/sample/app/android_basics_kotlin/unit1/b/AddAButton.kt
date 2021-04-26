package com.sample.app.android_basics_kotlin.unit1.b

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.sample.app.android_basics_kotlin.R


class AddAButton : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_a_button)
        val rollButton = findViewById<Button>(R.id.rollButton)
        rollButton.setOnClickListener { rollDice() }
    }

    private fun rollDice() {
        val dice = Dice(6)
        val diceRoll = dice.roll() // 抽選骰子數字
        val resultTextView = findViewById<TextView>(R.id.resultTextView) // 數字textView
        val resultImage = findViewById<ImageView>(R.id.resultImage) // 骰子imageView
        resultTextView.text = diceRoll.toString()
        val drawableResource = when(diceRoll){
            1 -> (R.drawable.dice_1)
            2 -> (R.drawable.dice_2)
            3 -> (R.drawable.dice_3)
            4 -> (R.drawable.dice_4)
            5 -> (R.drawable.dice_5)
            else -> (R.drawable.dice_6)
        }
        resultImage.setImageResource(drawableResource)
        resultImage.contentDescription = diceRoll.toString()
        Toast.makeText(this, "你骰出了${diceRoll}", Toast.LENGTH_SHORT).show()
    }
}

class Dice(private val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}

/**
 * 對應內容:
 * Add a button to an app
 * https://developer.android.com/courses/pathways/android-basics-kotlin-four
 * 練習目的：
 * 1. 建立骰子內容 可以骰骰子（show出數字) (官方sample code : https://github.com/google-developer-training/android-basics-kotlin-create-dice-roller-with-button-app-solution)
 * 2. 根據骰子內容改變圖案內容 (官方sample code : https://github.com/google-developer-training/android-basics-kotlin-dice-roller-with-images-app-solution)
 * 練習重點：
 * 了解產生數字範圍與亂數如何抽選
 * 了解Class
 * 了解頁面(xml)與程式(kt)如何互動
 * 了解按鈕如何運作(setOnClick)
 * 了解 if else, when使用方法
 * 了解toast如何使用
 * --
 * 額外補足:
 * 整理程式自動縮排快捷鍵：windows : Ctrl+Alt+L , mac : Command+Option+L
 * 練習部分:
 * 骰出兩個骰子分別show在不同的textView上
 **/