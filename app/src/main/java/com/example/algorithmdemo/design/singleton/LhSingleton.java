package com.example.algorithmdemo.design.singleton;

/**
 * Created by LJH on 2019/11/25
 * Description: 懒汉模式
 */
public class LhSingleton {

    private static LhSingleton singleton;

    private LhSingleton() {
    }

    /**
     * 线程不安全
     *
     * @return LhSingleton
     */
    public static LhSingleton getSingleton1() {
        if (singleton == null) {
            singleton = new LhSingleton();
        }
        return singleton;
    }

    /**
     * 线程安全
     *
     * @return LhSingleton
     */
    public static synchronized LhSingleton getInstance() {
        if (singleton == null) {
            singleton = new LhSingleton();
        }
        return singleton;
    }
}
