package com.example.algorithmdemo.algorithm

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.algorithmdemo.R
import com.example.algorithmdemo.util.getRandom
import kotlinx.android.synthetic.main.activity_binary_search.*

/**
 * Created by LJH on 2019/9/27
 * Description:二分查找
 */
class BinarySearchActivity : AppCompatActivity() {
    private val sb = StringBuilder()
    private lateinit var mArray: IntArray

    private var mTarget: Int? = null

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_binary_search)
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
            mTarget = (1..100).random()
            tvSearch.text = "查找元素：$mTarget"
        }

        btnSearch.setOnClickListener {
            if (mTarget == null) {
                Toast.makeText(this, "请先对数组进行排序", Toast.LENGTH_LONG).show()
            } else {
                val index = binarySearch(mArray, mTarget!!)
                tvSearch.text = "查找元素：$mTarget;${if (index == -1) {
                    "没找到"
                } else {
                    "下标 = $index"
                }
                }"
            }


        }

        btnRandom.setOnClickListener {
            getRandom()
        }
    }

    /**
     * 选择排序（升序 1-2-3）
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
     * 二分查找
     * @param array 有序数组
     * @param target 目标元素
     */
    private fun binarySearch(array: IntArray, target: Int): Int {
        //查找范围起始点
        var start = 0
        //查找范围终点
        var end = mArray.size - 1
        //查找范围中位数
        var mid: Int
        while (start <= end) {
            //mid = (start+end)/2  有可能溢出（比如：start = 0 ,end = 1,mid = 0）
            mid = start + (end - start) / 2
            when {
                //如果刚好相等，直接返回
                array[mid] == target -> return mid
                //如果小于目标元素，起始位 = 中位数+1
                array[mid] < target -> start = mid + 1
                //如果大于目标元素，结束位 = 中位数-1
                array[mid] > target -> end = mid - 1
            }
        }

        return -1
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
}