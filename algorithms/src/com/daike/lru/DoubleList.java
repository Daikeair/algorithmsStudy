package com.daike.lru;

/**
 * @Author alex.chen
 * @Date 2020-05-06 17:26
 * @Version 1.0
 * 利用Node构建双向链表
 */
public class DoubleList {
    /** 头尾虚节点 */
    private Node head,tail;
    /** 链表元素数 */
    private int size;

    /**
     *  初始构造方法,头尾均为虚节点*/
    public DoubleList(){
        this.head=new Node(0,0);
        this.tail=new Node(0,0);
        this.head.next=this.tail;
        this.tail.prev=this.head;
        this.size=0;
    }

    /**
     * 链表头部添加节点x,其中head当做虚拟节点处理，永远在最前面 */
    public void addFirst(Node x){
        //head为虚拟节点，当前head的下一个节点的地址（假设为a）赋值给要插入数值的后面，也就是x的next节点
        x.next=head.next;
        x.prev=head;
        //x的引用赋值给a节点的pre
        head.next.prev=x;
        //x的引用赋值给head虚拟节点的next
        head.next=x;
        size++;
    }

    /**
     *  删除链表中的节点x (x一定存在)*/
    public void remove(Node x){
        x.prev.next=x.next;
        x.next.prev=x.prev;
        size--;
    }

    /**
     *删除链表中最后一个节点，也就是tail虚拟节点前的一个节点，并返回该节点*/

    public Node removeLast(){
        if(tail.prev==head){
            return null;
        }
        Node last=tail.prev;
        remove(last);
        return  last;
    }

    /**
     * 返回链表长度
     */
    public int size(){
        return size;
    }

}
