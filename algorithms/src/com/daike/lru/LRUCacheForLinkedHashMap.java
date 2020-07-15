package com.daike.lru;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author alex.chen
 * @Date 2020-07-14 23:15
 * @Version 1.0
 *
 * 需求分析：
 *  1.需要读取信息----HashMap
 *  2.能加入新的信息，且新加入的信息most recently used
 *  3.加入新的信息前，需要看有没有空位，如果没有，则需要找出老家伙并踢出
 *  4.加入的新信息是缓存里已经存在的，更新value，并升级为最近使用的
 *
 *  从老到新排排站，删除、插入、移动的处理---Doubly LinkedList的复杂度都是O(1)
 *
 */
public class LRUCacheForLinkedHashMap  extends LinkedHashMap<Integer,Integer>{

    private int capacity;

    public LRUCacheForLinkedHashMap(int capacity) {
        super(capacity, 0.75F, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    // 这个可不写
    public void put(int key, int value) {
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }

}
