package com.example.algorithmdemo.design.singleton;

/**
 * Created by LJH on 2019/11/25
 * Description: 饿汉模式（线程安全）  基于类加载机制
 */
public class EhSingleton {
    private static EhSingleton singleton = new EhSingleton();

    private EhSingleton() {
    }

    public static EhSingleton getInstance() {
        return singleton;
    }

}
