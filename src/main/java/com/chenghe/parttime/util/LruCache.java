package com.chenghe.parttime.util;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by lenovo on 2019/7/23.
 */
public class LruCache<T,E> {

    HashMap<T,E> map = null;

    private int maxSize;

    public LruCache(int size){
        maxSize = size;
        map = new LinkedHashMap<T,E>(maxSize + 1, 0.75f, true){
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() >= maxSize;
            }
        };
    }

    public synchronized void put(T key,E value){
        map.put(key,value);
    }

    public synchronized void remove(String key){
        map.remove(key);
    }

    public E get(T key){
        return map.get(key);
    }

    public static void main(String[] args) {
        LruCache<Integer,String> lruCache = new LruCache<Integer,String>(11);
        System.out.println(lruCache.get(11));
    }
}
