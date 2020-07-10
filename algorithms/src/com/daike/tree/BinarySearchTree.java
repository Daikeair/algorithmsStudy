package com.daike.tree;

/**
 * @Author alex.chen
 * @Date 2020-05-06 16:10
 * @Version 1.0
 * Java code to find k'th largest element in BST
 */
public class BinarySearchTree {
    /** Root of BST */
    Node root;

    /** Constructor */
    BinarySearchTree(){
        root=null;
    }

    /** function to insert nodes */
    public void insert(int data){
        this.root=this.insertRec(this.root,data);
    }

    Node insertRec(Node node,int data){
        /* If the tree is empty, return a new node */
        if(node==null){
            this.root=new Node(data);
            return this.root;
        }
        if (data == node.data) {
            return node;
        }
        /* Otherwise, recur down the tree */
        if(data<node.data){
            node.left=insertRec(node.left,data);
        }else {
            node.right=insertRec(node.right,data);
        }
        return node;
    }

    /**class that stores the value of count */
    public class count {
        int c = 0;
    }

    /**
     * utility function to find kth largest no in a given tree
     */
    void kthLargestUtil(Node node, int k, count C)
    {
        // Base cases, the second condition is important to
        // avoid unnecessary recursive calls
        if (node == null || C.c >= k) {
            return;
        }

        // Follow reverse inorder traversal so that the
        // largest element is visited first
        this.kthLargestUtil(node.right, k, C);

        // Increment count of visited nodes
        C.c++;

        // If c becomes k now, then this is the k'th largest
        if (C.c == k) {
            System.out.println(k + "th largest element is " +
                    node.data);
            return;
        }

        // Recur for left subtree
        this.kthLargestUtil(node.left, k, C);
    }

    /**
     *     Method to find the kth largest no in given BST
      */
    void kthLargest(int k)
    {
        // object of class count
        count c = new count();
        this.kthLargestUtil(this.root, k, c);
    }







    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

        /* Let us create following BST
              50
           /     \
          30      70
         /  \    /  \
       20   40  60   80 */
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        for (int i = 1; i <= 7; i++) {
            tree.kthLargest(i);
        }
    }

}

