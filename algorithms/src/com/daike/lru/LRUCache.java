package com.daike.lru;

import java.util.HashMap;




/**
 * @Author alex.chen
 * @Date 2020-05-06 18:11
 * @Version 1.0
 * LRU缓存淘汰策略实现
 */
public class LRUCache {
    /** key 映射到 Node(key, val)*/
    private HashMap<Integer, Node> map;
    /** 双向链表 Node(k1, v1) <-> Node(k2, v2)...*/
    private DoubleList cache;
    /** 最大容量*/
    private int cap;

    /**
     * 初始化LRUCache
     */
    public LRUCache(int capacity){
        this.cap=capacity;
        map=new HashMap<>();
        cache=new DoubleList();
    }

    /**
     * get获取
     */
    public int get(int key){
        if(!map.containsKey(key)){
            return -1;
        }

        int value=map.get(key).val;
        //利用put方法将该数据提到开头
        put(key,value);
        return value;

    }

    /**
     * put插入
     */

    public void put(int key,int value){
        //做出新的节点x
        Node x=new Node(key,value);

        if(map.containsKey(key)){
            //旧的数据存在，则将其删除，并将新的数据插在开头
            cache.remove(x);
            cache.addFirst(x);
            //更新map中对应的数据
            map.put(key,x);
        }else
            if(cap==cache.size()){
                /**
                 容量已满，则删除最后一个
                 *当缓存容量已满，我们不仅仅要删除最后一个 Node 节点，
                 * 还要把 map 中映射到该节点的 key 同时删除，而这个 key 只能由 Node 得到。
                 * 如果 Node 结构中只存储 val，那么我们就无法得知 key 是什么，就无法删除 map 中的键，造成错误。
                 */

                Node last = cache.removeLast();
                map.remove(last.key);
        }
            //直接添加到头部
        cache.addFirst(x);
            map.put(key,x);
    }

}
