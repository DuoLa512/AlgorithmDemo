package com.example.algorithmdemo.design.factory

/**
 * Created by LJH on 2019/11/20
 * Description:玛莎拉蒂
 */
class Maserati : Car() {
    override fun produce() {
        println("生产了一辆玛莎拉蒂")
    }
}