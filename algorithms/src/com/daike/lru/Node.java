package com.daike.lru;

/**
 * @Author alex.chen
 * @Date 2020-05-06 17:23
 * @Version 1.0
 * 双链表节点类
 */
public class Node {
    public int key,val;
    public Node next,prev;

    public Node(int k,int v){
        this.key=k;
        this.val=v;
    }
}
