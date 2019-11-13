package com.example.algorithmdemo.design.proxy

/**
 * Created by LJH on 2019/11/13
 * Description:静态代理类
 */
class ProxyShopper(private val IShop: IShop) : IShop {

    override fun buy() {
        IShop.buy()
        println("代理帮你购买...")
    }
}