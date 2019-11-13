package com.example.algorithmdemo.design.proxy

import java.lang.reflect.Proxy

/**
 * Created by LJH on 2019/11/13
 * Description:客户端类
 */
object Client {
    @JvmStatic
    fun main(args: Array<String>) {
        //创建真正需要购买者
        val shopper :IShop= Shopper()
        /*//创建静态代理
        val proxyShopper:IShop = ProxyShopper(shopper)
        proxyShopper.buy()*/

        //创建动态代理
        val dynamicProxyShopper = DynamicProxyShopper(shopper)
        //创建类加载器
        val loader = shopper.javaClass.classLoader as ClassLoader
        //动态创建代理类
        val proxyShopper = Proxy.newProxyInstance(loader, arrayOf<Class<*>>(IShop::class.java),dynamicProxyShopper) as IShop
        proxyShopper.buy()
    }
}
