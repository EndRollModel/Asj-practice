package com.sample.app.android_basics_kotlin.unit1.a

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sample.app.android_basics_kotlin.R

/**
 * 本Case並無撰寫任何程式碼
 * 對應內容 :
 * Build a basic layout
 * https://developer.android.com/courses/pathways/android-basics-kotlin-three
 * 練習目的：
 * 建立一個生日賀卡 (文字中間有個圖片)
 * 官方sample code :
 * https://github.com/google-developer-training/android-basics-kotlin-birthday-card-app-solution
 * https : //github.com/google-developer-training/android-basics-kotlin-birthday-card-with-image-app-solution
 * 練習重點 ：
 * TextView的操作與設定
 * Layout邊緣距離設定 (ConstraintLayout的操作設定)
 * Resource Manager的操作（放入圖片)
 * ImageView的設定與操作
 * UI擺放順序等內容了解
 * --
 * 額外補足
 * 1. string可經由string.xml去建立
 * 2. 文字建議使用sp而不是dp (sp與dp補充: https://developer.android.com/training/multiscreen/screendensities)
 * 3. 若有黃色警告 能盡量處裡就盡量處理
 * --
 * 練習部分
 * 自製類似畫面
 * 增加陰影與大小測試版面
 * */

class BasicLayout : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_basic_layout)
    }
}

