package com.example.algorithmdemo.design.factory

/**
 * Created by LJH on 2019/11/20
 * Description:具体工厂类
 */
class CarFactory : BaseCarFactory() {
    override fun <T : Car> produceCar(clz: Class<T>): T {
        var car: Car? = null
        val className = clz.name
        try {
            car = Class.forName(className).newInstance() as? Car
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return  car as T
    }
}