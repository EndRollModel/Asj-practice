package com.sample.app.android_basics_kotlin.unit3.a

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sample.app.android_basics_kotlin.R
import com.sample.app.android_basics_kotlin.databinding.ActivityWordsMainBinding


/**
 * 對應內容:
 * Navigate between screens
 * https://developer.android.com/courses/pathways/android-basics-kotlin-unit-3-pathway-1#codelab-https://developer.android.com/codelabs/basic-android-kotlin-training-activities-intents
 * 練習目的：
 * 1. 建立RecyclerView清單 點選後 google搜尋該按鈕關鍵字
 * 練習重點：
 * 了解資料傳遞的方式(使用Intent於app內傳遞內容或是呼叫其他內容)
 * 使用Menu做多功能選單內容
 * 切換RecyclerView的layout為Linear或是Grid模式
 **/

class WordsMainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private var isLinearLayoutManager = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityWordsMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        recyclerView = binding.recyclerView
        // Sets the LinearLayoutManager of the recyclerview
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = LetterAdapter()
        chooseLayout()
    }
    private fun chooseLayout(){
        if(isLinearLayoutManager){
            recyclerView.layoutManager = LinearLayoutManager(this)
        }else{
            recyclerView.layoutManager = GridLayoutManager(this, 4);
        }
        recyclerView.adapter = LetterAdapter()
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.layout_menu, menu)

        val layoutButton = menu?.findItem(R.id.action_switch_layout)
        // Calls code to set the icon based on the LinearLayoutManager of the RecyclerView
        setIcon(layoutButton)

        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_switch_layout -> {
                // Sets isLinearLayoutManager (a Boolean) to the opposite value
                isLinearLayoutManager = !isLinearLayoutManager
                // Sets layout and icon
                chooseLayout()
                setIcon(item)

                return true
            }
            //  Otherwise, do nothing and use the core event handling

            // when clauses require that all possible paths be accounted for explicitly,
            //  for instance both the true and false cases if the value is a Boolean,
            //  or an else to catch all unhandled cases.
            else -> super.onOptionsItemSelected(item)
        }
    }
    private fun setIcon (menuItem: MenuItem?){
        if (menuItem == null)
            return

        // Set the drawable for the menu icon based on which LayoutManager is currently in use

        // An if-clause can be used on the right side of an assignment if all paths return a value.
        // The following code is equivalent to
        // if (isLinearLayoutManager)
        //     menu.icon = ContextCompat.getDrawable(this, R.drawable.ic_grid_layout)
        // else menu.icon = ContextCompat.getDrawable(this, R.drawable.ic_linear_layout)
        menuItem.icon =
            if (isLinearLayoutManager)
                ContextCompat.getDrawable(this, R.drawable.ic_baseline_view_module)
            else ContextCompat.getDrawable(this, R.drawable.ic_baseline_view_list)
    }
}