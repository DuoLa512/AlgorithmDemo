package com.example.algorithmdemo.design.builder

/**
 * Created by LJH on 2019/12/2
 * Description:
 */
object Client {

    @JvmStatic
    fun main(args: Array<String>) {
        val builder = ComputerBuilder()
        val director = Director(builder)
        director.createComputer("i9-5210", "华擎玩家至尊", "三星DDR4")
    }
}