package com.daike.tree;

/**
 * @Author alex.chen
 * @Date 2020-05-06 15:29
 * @Version 1.0
 */
public class Node {

        int data;
        Node left, right;

        Node(int item)
        {
            data = item;
            left = right = null;
        }
    }
