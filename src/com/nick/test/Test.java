package com.nick.test;

import com.nick.adt.list.MyArrayList;

import java.util.Iterator;

public class Test {
    public static void main(String[] args) {
        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(3);
        list.add(2);
        list.add(5);
        list.add(8);
        printList(list);
        list.add(1, 11);
        printList(list);
        list.remove(2);
        printList(list);
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            int i = iterator.next();
            if (i == 5) {
                iterator.remove();
            }
        }
        printList(list);
    }
    public static void printList(MyArrayList<Integer> list) {
        for (Integer i : list) {
            System.out.print(i + "\t");
        }
        System.out.println();
    }
}
