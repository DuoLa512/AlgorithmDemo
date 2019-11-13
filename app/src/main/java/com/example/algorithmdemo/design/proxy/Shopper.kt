package com.example.algorithmdemo.design.proxy

/**
 * Created by LJH on 2019/11/13
 * Description:真正主题类
 */
class Shopper :IShop{
    override fun buy() {
        println("我要购买东西...")
    }
}