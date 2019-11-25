package com.example.algorithmdemo.design.singleton;

/**
 * Created by LJH on 2019/11/25
 * Description: 双重检查模式：DCL（线程安全）
 */
public class DclSingleton {
    private volatile static DclSingleton singleton;

    private DclSingleton() {
    }

    public DclSingleton getSingleton() {
        //为了不必要的同步
        if (singleton == null) {
            synchronized (DclSingleton.class) {
                //对象判空
                if (singleton == null) {
                    singleton = new DclSingleton();
                }
            }
        }
        return singleton;
    }
}
