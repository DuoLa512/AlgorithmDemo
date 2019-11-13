package com.example.algorithmdemo.design.proxy

import java.lang.reflect.InvocationHandler
import java.lang.reflect.Method

/**
 * Created by LJH on 2019/11/13
 * Description:动态代理类
 */
class DynamicProxyShopper(private val any: Any) : InvocationHandler {
    @Throws
    override fun invoke(proxy: Any?, method: Method?, args: Array<out Any>?): Any? {
        val result = method?.invoke(any,*(args?: arrayOfNulls<Any>(0)))
        println("代理帮你购买...")
        return result
    }
}