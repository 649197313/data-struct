package com.nick.test;

import com.nick.adt.list.MyArrayList;
import com.nick.adt.list.MyLinkedList;

import javax.xml.soap.Node;
import java.util.Arrays;
import java.util.Iterator;

public class Test {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        test(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void test(int[] arr) {
        arr = new int[]{2, 3, 4};
        System.out.println(Arrays.toString(arr));
    }
}
