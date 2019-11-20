package com.example.algorithmdemo.design.factory

/**
 * Created by LJH on 2019/11/20
 * Description:
 */
object Client {

    @JvmStatic
    fun main(args: Array<String>) {

        val carFactory: BaseCarFactory = CarFactory()
        val maserati: Maserati = carFactory.produceCar(Maserati::class.java)
        maserati.produce()

        val ferrari = carFactory.produceCar(Ferrari::class.java)
        ferrari.produce()

    }
}