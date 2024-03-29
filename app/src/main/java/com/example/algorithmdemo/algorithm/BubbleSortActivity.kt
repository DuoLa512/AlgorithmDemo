package com.example.algorithmdemo.algorithm

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.algorithmdemo.R
import com.example.algorithmdemo.util.getRandom
import kotlinx.android.synthetic.main.activity_sort.*
import kotlinx.android.synthetic.main.activity_sort.btnAsc
import kotlinx.android.synthetic.main.activity_sort.btnDes
import kotlinx.android.synthetic.main.activity_sort.btnRandom
import kotlinx.android.synthetic.main.activity_sort.tvAsc
import kotlinx.android.synthetic.main.activity_sort.tvDes

/**
 * Created by LJH on 2019/9/25
 * Description:冒泡算法
 */
class BubbleSortActivity : AppCompatActivity() {
    private val sb = StringBuilder()
    private lateinit var mArray: IntArray
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sort)
        tvTimeFzd.text = "冒泡排序的时间复杂度:O(n²)"
        mArray = getRandom(100, 10)
        sb.append("随机10个数字： ")
        mArray.forEachIndexed { index, i ->
            sb.append(i)
            if (index < mArray.size - 1) {
                sb.append(" ; ")
            }
        }

        tvNumbers.text = sb


        btnAsc.setOnClickListener {
            tvAsc.text = getAscData()
        }

        btnDes.setOnClickListener {
            tvDes.text = getDesData()
        }
        btnRandom.setOnClickListener {
            getRandom()
        }
    }

    /**
     * 生产随机数
     */
    private fun getRandom() {
        sb.clear()
        mArray = getRandom(100, 10)
        sb.append("随机10个数字： ")
        mArray.forEachIndexed { index, i ->
            sb.append(i)
            if (index < mArray.size - 1) {
                sb.append(" ; ")
            }
        }
        tvNumbers.text = sb

    }

    /**
     * 升序 1-2-3
     */
    private fun getAscData(): String {
        sb.clear()
        sb.append("升序数据：")
        var tmp: Int
        for (i in mArray.indices) {
            for (j in 0 until mArray.size - 1 - i) {
                if (mArray[j] > mArray[j + 1]) {
                    tmp = mArray[j]
                    //小的往左移
                    mArray[j] = mArray[j + 1]
                    //大的往右移
                    mArray[j + 1] = tmp
                }
            }
        }

        mArray.forEachIndexed { index, i ->
            sb.append(i)
            if (index < mArray.size - 1) {
                sb.append(" ; ")
            }
        }
        return sb.toString()

    }

    /**
     * 降序 3-2-1
     */
    private fun getDesData(): String {
        sb.clear()
        sb.append("降序数据：")
        var tmp: Int
        for (i in mArray.indices) {
            for (j in 0 until mArray.size - 1 - i) {
                if (mArray[j] < mArray[j + 1]) {
                    tmp = mArray[j]
                    //大的往左移
                    mArray[j] = mArray[j + 1]
                    //小的往右移
                    mArray[j + 1] = tmp
                }
            }
        }

        mArray.forEachIndexed { index, i ->
            sb.append(i)
            if (index < mArray.size - 1) {
                sb.append(" ; ")
            }
        }

        return sb.toString()
    }
}