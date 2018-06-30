package com.nick.test;

import com.nick.tree.BinaryTree;

public class BinaryTreeTest {
    public static void main(String[] args) {
        BinaryTree<Integer> tree = new BinaryTree<>();
        int[] arr = {40, 10, 20, 15, 14, 16, 22, 1};
        for (int i = 0; i < arr.length; i++) {
            tree.insert(arr[i]);
        }
        tree.remove(10);
        tree.show();
    }
}
