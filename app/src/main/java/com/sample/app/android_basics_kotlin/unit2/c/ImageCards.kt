package com.sample.app.android_basics_kotlin.unit2.c

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import com.sample.app.android_basics_kotlin.R
import com.sample.app.android_basics_kotlin.unit2.c.adapter.ItemAdapter
import com.sample.app.android_basics_kotlin.unit2.c.data.Datasource

/**
 * 對應內容:
 * Display a scrollable list
 * https://developer.android.com/courses/pathways/android-basics-kotlin-unit-2-pathway-3
 *
 * 官方sample :
 * https://github.com/google-developer-training/android-basics-kotlin-affirmations-app-solution
 *
 * 練習目的：
 * List應用
 * while迴圈的使用
 * recyclerview去建立cardView List
 *
 * 練習重點：
 * 了解list與MutableList運作模式(陣列的概念)
 * RecyclerView, adapter使用
 * dataClass使用
 *
 * 額外補足:
 * list: 建立後只可read
 * mutableList : 建立後可以 add remove
 * data -> adapter -> recyclerview -> show Data
 * 練習部分:
 * 將layoutManager替換為GridLayoutManager觀察變化
 * 行列改為三行
 * 改變adapter的內容觀察變化
 **/
class ImageCards : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_CardList)
        setContentView(R.layout.activity_image_cards)
        val myDataSet = Datasource().loadAffirmations()
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.adapter = ItemAdapter(this, myDataSet)
        recyclerView.setHasFixedSize(true)
    }

}