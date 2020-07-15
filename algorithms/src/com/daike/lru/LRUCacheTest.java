package com.daike.lru;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author alex.chen
 * @Date 2020-07-14 23:50
 * @Version 1.0
 *
 *
 * * 需求分析：
 *  1.需要读取信息----HashMap
 *  2.能加入新的信息，且新加入的信息most recently used
 *  3.加入新的信息前，需要看有没有空位，如果没有，则需要找出老家伙并踢出
 *  4.加入的新信息是缓存里已经存在的，更新value，并升级为最近使用的
 *
 *  从老到新排排站，删除、插入、移动的处理---Doubly LinkedList的复杂度都是O(1)
 *
 */
public class LRUCacheTest {

    //HashMap:<key=Question,value=ListNode>
    //LinkedList:<Answer>

    /**构成linkedList的节点*/
    public static class Node{
        int key;
        int val;
        Node next;
        Node prev;
        public Node(int key,int val){
            this.key=key;
            this.val=val;
        }
    }

    Map<Integer,Node> map=new HashMap<>();
    private Node head;
    private Node tail;
    private int capacity;

    public LRUCacheTest(int capacity){
        this.capacity=capacity;
    }

    /**
     * 从缓存获取元素（获取完后悔删除节点，并把节点重新放在链表头部）
     * @param key
     * @return
     */
    public int get(int key){
        Node node=map.get(key);
        if(node==null){
            return -1;
        }else{
            int res=node.val;
            remove(node);
            appendHead(node);
            return  res;

        }
    }

    /**
     * 存入一个元素进缓存
     * @param key
     * @param value
     */
    public void put(int key,int value){
        //先check有没有这个key
        Node node=map.get(key);
        if(node !=null){
            node.val=value;
            //把这个node放到最前面去
            remove(node);
            appendHead(node);
        }else{
            node=new Node(key,value);
            if(map.size()<capacity){
                appendHead(node);
                map.put(key,node);
            }else{
                //去除队尾的（最老的）
                map.remove(tail.key);
                remove(tail);
                appendHead(node);
                map.put(key,node);
            }
        }

    }

    /**将节点放在头部*/
    private void appendHead(Node node) {
        if(head==null){
            head=tail=node;
        }else{
            node.next=head;
            head.prev=node;
            head=node;
        }
    }

    /**
     * 移除linkedList中的某个节点
     * @param node
     */
    private void remove(Node node) {
        if(head==tail){
            head=tail=null;
        }else{
            if(head==node){
                head=head.next;
                node.next=null;
            }else if(tail==node){
                tail=tail.prev;
                tail.next=null;
                node.prev=null;
            }else{
                node.prev.next=node.next;
                node.next.prev=node.prev;
                node.prev=null;
                node.next=null;
            }

        }
    }


}
