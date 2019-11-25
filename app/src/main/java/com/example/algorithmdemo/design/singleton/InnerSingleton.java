package com.example.algorithmdemo.design.singleton;

/**
 * Created by LJH on 2019/11/25
 * Description: 静态内部类单例模式 (线程安全)
 */
public class InnerSingleton {

    private InnerSingleton(){}

    private static class SingletonHolder{
        private static final InnerSingleton singleton = new InnerSingleton();
    }

    public static InnerSingleton getInstance(){
        return SingletonHolder.singleton;
    }
}
