package com.nick.adt.list;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyArrayList<AnyType> implements Iterable<AnyType> {

    private static final int DEFAULT_CAPACITY = 10;
    private int theSize;
    private AnyType[] theItems;

    public MyArrayList() {
        this.clear();
    }
    public void clear() {
        theSize = 0;
        ensureCapacity(DEFAULT_CAPACITY);
    }

    public int size() {
        return theSize;
    }
    public boolean isEmpty(){
        return theSize == 0 ? true : false;
    }
    public void trimToSize(){
        ensureCapacity(size());
    }
    public AnyType get(int index) {
        if (index < 0 || index >= size())
            throw new ArrayIndexOutOfBoundsException();
        return theItems[index];
    }

    public AnyType set(int index, AnyType at) {
        if (index < 0 || index >= size())
            throw new ArrayIndexOutOfBoundsException();
        AnyType anyType = theItems[index];
        theItems[index] = at;
        return anyType;
    }

    public void ensureCapacity(int newCapacity) {
        if (newCapacity < theSize) {
            return;
        }
        AnyType[] oldItems = theItems;
        theItems = (AnyType[]) new Object[newCapacity];
        for (int i = 0; i < theSize; i++) {
            theItems[i] = oldItems[i];
        }
    }
    public boolean add(AnyType at) {
        add(size(), at);
        return true;
    }
    public boolean add(int index, AnyType at) {
        if (index < 0 || index > size())
            throw new ArrayIndexOutOfBoundsException();
        if (size() == theItems.length) {
            ensureCapacity(size() * 2);
        }
        for (int i = size(); i > index; i--) {
            theItems[i] = theItems[i - 1];
        }
        theItems[index] = at;
        theSize++;
        return true;
    }

    public AnyType remove(int index) {
        if (index < 0 || index > size())
            throw new ArrayIndexOutOfBoundsException();
        AnyType res = theItems[index];
        for (int i = index; i < theSize - 1; i++) {
            theItems[i] = theItems[i + 1];
        }
        theSize--;
        return res;
    }

    @Override
    public Iterator<AnyType> iterator() {
        return new MyArrayListIterator<>();
    }

    private class MyArrayListIterator<AnyType> implements Iterator<AnyType> {

        int current = 0;

        @Override
        public boolean hasNext() {
            if (current < theSize) {
                return true;
            }
            return false;
        }

        @Override
        public AnyType next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return (AnyType) theItems[current++];
        }

        @Override
        public void remove() {
            MyArrayList.this.remove(--current);
        }
    }
}
