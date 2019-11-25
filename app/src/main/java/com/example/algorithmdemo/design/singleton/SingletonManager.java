package com.example.algorithmdemo.design.singleton;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by LJH on 2019/11/25
 * Description:使用容器实现单例模式（线程安全）
 */
public class SingletonManager {
    private static Map<String, Object> objMap = new HashMap<>();

    private SingletonManager() {
    }

    public static void registerService(String key, Object instance) {
        if (!objMap.containsKey(key)) {
            objMap.put(key, instance);
        }
    }

    public static Object getIntance(String key) {
        return objMap.get(key);
    }
}
