package com.example.algorithmdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //冒泡排序
        btnMp.setOnClickListener {
            startActivity<BubbleActivity>()
        }

        //快速排序
        btnKp.setOnClickListener {
            startActivity<QuickSortActivity>()
        }
    }
}
