package com.example.algorithmdemo.design.factory

/**
 * Created by LJH on 2019/11/20
 * Description:抽象工厂类
 */
abstract class BaseCarFactory {

    abstract fun <T : Car> produceCar(clz: Class<T>): T
}