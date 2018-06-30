package com.nick.adt.list;

import java.util.Iterator;

public class MyLinkedList<AnyType> implements Iterable<AnyType>{

    private int theSize;
    private int modCount;
    private Node<AnyType> head;
    private Node<AnyType> tail;

    public MyLinkedList() {
        clear();
    }

    public void clear() {
        theSize = 0;
        modCount = 0;
        head = new Node<>(null);
        tail = new Node<>(null);
        head.next = tail;
        tail.prev = head;
    }
    public int size() {
        return theSize;
    }
    public boolean isEmpty() {
        return theSize == 0 ? true : false;
    }

    public boolean add(AnyType anyType) {
        add(theSize, anyType);
        return true;
    }

    public void add(int index, AnyType anyType) {
        Node<AnyType> next = getNode(index);
        Node<AnyType> node = new Node<>(anyType);
        addBefore(node, next);
        theSize++;
    }

    public void append(Node<AnyType> prev, Node<AnyType> node) {
        node.prev = prev;
        node.next = prev.next;
        prev.next.prev = node;
        prev.next = node;
    }
    public AnyType get(int index) {
        if (index < 0 || index >= theSize) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return getNode(index).data;
    }

    public AnyType set(int index, AnyType anyType) {
        if (index < 0 || index >= theSize) {
            throw new ArrayIndexOutOfBoundsException();
        }
        Node<AnyType> node = getNode(index);
        AnyType res = node.data;
        node.data = anyType;
        return res;
    }

    public AnyType remove(int index) {
        if (index < 0 || index >= theSize) {
            throw new ArrayIndexOutOfBoundsException();
        }
        Node<AnyType> node = getNode(index);
        node.prev.next = node.next;
        node.next.prev = node.prev;
        return node.data;
    }


    public void addBefore(Node<AnyType> node, Node<AnyType> next) {
        node.next = next;
        node.prev = next.prev;
        next.prev.next = node;
        next.prev = node;
    }


    private Node<AnyType> getNode(int index) {
        Node<AnyType> res = head.next;
        for (int i = 0; i < index; i++) {
            res = res.next;
        }
        return res;
    }

    private class MyLinkedListIterator<AnyType> implements Iterator<AnyType> {

        Node<AnyType> current = (Node<AnyType>) head.next;

        @Override
        public boolean hasNext() {
            // 检查modcount是否有变化，如果变化了就抛出ModificationException
            if (current != tail) {
                return true;
            }
            return false;
        }

        @Override
        public AnyType next() {
            if (!hasNext()) {
                throw new ArrayIndexOutOfBoundsException();
            }
            AnyType res = current.data;
            current = current.next;
            return res;
        }

        @Override
        public void remove() {
            if (current.prev == head) {
                throw new ArrayIndexOutOfBoundsException();
            }
            MyLinkedList.this.removeNode(current.prev);
        }
    }

    private <AnyType> void removeNode(Node<AnyType> node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    @Override
    public Iterator<AnyType> iterator() {
        return new MyLinkedListIterator<AnyType>();
    }


    private static class Node<AnyType> {
        AnyType data;
        Node<AnyType> prev;
        Node<AnyType> next;

        public Node(AnyType data) {
            this.data = data;
        }
    }
}
