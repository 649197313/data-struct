package com.nick.skip;

public class SkipListNode {

    int key;
    Object value;
    SkipListNode left, right, up, down;

    public SkipListNode(int key, Object value) {
        this.key = key;
        this.value = value;
    }



}
