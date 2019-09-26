package com.example.algorithmdemo

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.algorithmdemo.util.getRandom
import kotlinx.android.synthetic.main.activity_quick_sort.*

/**
 * Created by LJH on 2019/9/25
 * Description:快速排序
 */
class QuickSortActivity : AppCompatActivity() {
    private val TAG = QuickSortActivity::class.java.simpleName
    private lateinit var mArray: IntArray
    private val sb = StringBuilder()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quick_sort)
        mArray = getRandom(100, 10)
        sb.append("随机10个数字： ")
        mArray.forEachIndexed { index, i ->
            sb.append(i)
            if (index < mArray.size - 1) {
                sb.append(" ; ")
            }
        }
        tvRandom.text = sb

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
     * 升序 1-2-3
     */
    private fun getAscData(): String {
        sb.clear()
        sb.append("升序数据：")
        quickSort(true, mArray, 0, mArray.size - 1)
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
        quickSort(false, mArray, 0, mArray.size - 1)
        mArray.forEachIndexed { index, i ->
            sb.append(i)
            if (index < mArray.size - 1) {
                sb.append(" ; ")
            }
        }
        return sb.toString()
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
        tvRandom.text = sb

    }

    /**
     * 快速排序
     * @param isAsc 是否是升序排序
     * @param array 数组
     * @param startIndex 起始下标
     * @param endIndex 结束下标
     */
    private fun quickSort(isAsc: Boolean, array: IntArray, startIndex: Int, endIndex: Int) {
        //开始下标大于等于结束下标时，结束递归
        if (startIndex >= endIndex) {
            return
        }

        //等到基准元素位置
        val pivotIndex = partition(isAsc, array, startIndex, endIndex)
        Log.d(
            TAG, "${if (isAsc) {
                "升序"
            } else {
                "降序"
            }}基准元素位置：=$pivotIndex"
        )
        //根据基准元素，分成两部分递归排序
        quickSort(isAsc, array, startIndex, pivotIndex - 1)
        quickSort(isAsc, array, pivotIndex + 1, endIndex)
    }


    /**
     * 获取基准元素位置
     * @param isAsc 是否是升序排序
     * @param array 数组
     * @param startIndex 起始下标
     * @param endIndex 结束下标
     */
    private fun partition(isAsc: Boolean, array: IntArray, startIndex: Int, endIndex: Int): Int {
        //取第一个位置的元素作为基准元素
        val pivot = array[startIndex]
        var left = startIndex
        var right = endIndex
        while (left != right) {
            //升序
            if (isAsc) {
                //控制right指针比较，如果右边元素大于基准元素，并左移
                while (left < right && array[right] > pivot) {
                    right--
                }
                //控制left指针比较，如果左边元素小于等于基准元素，并右移
                while (left < right && array[left] <= pivot) {
                    left++
                }

            } else {//降序
                //控制right指针比较,如果右边元素小于基准元素，并左移
                while (left < right && array[right] < pivot) {
                    right--
                }
                //控制left指针比较，如果左边元素大于等于基准元素，并右移
                while (left < right && array[left] >= pivot) {
                    left++
                }
            }
            //交换left和right指向的元素
            if (left < right) {
                val tmp = array[left]
                array[left] = array[right]
                array[right] = tmp
            }

        }
        //pivot和指针重合点交换
        val tmp = array[left]
        array[left] = array[startIndex]
        array[startIndex] = tmp
        return left
    }

}