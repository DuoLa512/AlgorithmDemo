package com.example.algorithmdemo.util

/**
 * Created by LJH on 2019/9/25
 * Description:随机数工具类
 */
/**
 * 生成随机数
 * @param random 随机数范围
 * @param num 生成N个随机数
 */
fun getRandom(random: Int, num: Int): IntArray {
    val array = IntArray(num)
    for (i in 0 until num) {

        array[i] = (1..random).random()
    }
    return array
}