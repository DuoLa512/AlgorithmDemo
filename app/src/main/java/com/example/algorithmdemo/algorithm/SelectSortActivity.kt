package com.example.algorithmdemo.algorithm

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.algorithmdemo.R
import com.example.algorithmdemo.util.getRandom
import kotlinx.android.synthetic.main.activity_sort.*

/**
 * Created by LJH on 2019/9/27
 * Description:选择排序
 */
class SelectSortActivity : AppCompatActivity() {

    private val sb = StringBuilder()
    private lateinit var mArray: IntArray

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sort)
        tvTimeFzd.text = "选择排序的时间复杂度:O(n²)"
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
        for (i in 0 until mArray.size - 1) {
            var minIndex = i
            for (j in (i + 1) until mArray.size) {
                minIndex = if (mArray[minIndex] < mArray[j]) {
                    minIndex
                } else {
                    j
                }
            }
            //交换位置
            val tmp = mArray[i]
            mArray[i] = mArray[minIndex]
            mArray[minIndex] = tmp

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
        for (i in 0 until mArray.size - 1) {
            var maxIndex = i
            for (j in i + 1 until mArray.size) {
                maxIndex = if (mArray[maxIndex] > mArray[j]) {
                    maxIndex
                } else {
                    j
                }

            }

            //交换位置
            val tmp = mArray[i]
            mArray[i] = mArray[maxIndex]
            mArray[maxIndex] = tmp
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