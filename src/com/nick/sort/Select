package com.nick.sort;

import java.util.Arrays;
import java.util.Random;

public class Sort {

    public static void main(String[] args) {
//        int[] arr = {3, 8, 1, 4, 2};
            int[] arr = {10, 80, 24, 52, 49, 22, 57, 9, 89, 50, 67, 21, 38, 77, 44, 49, 70, 33, 95, 97, 58, 57, 64, 49, 78, 30, 60, 86, 58, 86};
        quickSort2(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    static void insertionSort(int[] arr) {
        int j;
        for (int i = 1; i < arr.length; i++) {
            int tmp = arr[i];
            for (j = i; j > 0 && tmp < arr[j - 1]; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = tmp;
        }
    }

    static void quickSort2(int[] arr, int low, int high) {
        if (low >= high) {
            return;
        }
        int k = partition(arr, low, high);
        quickSort2(arr, low, k - 1);
        quickSort2(arr, k + 1, high);
    }
    static int partition(int[] arr, int low, int high) {
        int pivot = arr[low];
        int cursor = low + 1;
        int k = low;
        while (cursor <= high) {
            if (arr[cursor] <pivot){
                k++;
                int tmp = arr[k];
                arr[k] = arr[cursor];
                arr[cursor] = tmp;
            }
            cursor++;
        }
        arr[low] = arr[k];
        arr[k] = pivot;
        return k;
    }


    static void quickSort(int[] arr, int low, int hi) {
        int start = low;
        int end = hi;
        int base = arr[end];
        while (start < end) {
            while (start < end && arr[start] <= base) {
                start++;
            }
            if (start < end) {
                int tmp = arr[start];
                arr[start] = arr[end];
                arr[end] = tmp;
            }
            while (start < end && arr[end] >= base) {
                end--;
            }
            if (start < end) {
                int tmp = arr[start];
                arr[start] = arr[end];
                arr[end] = tmp;
            }
        }
        if (start > low) quickSort(arr, low, start - 1);
        if (start < hi) quickSort(arr, start + 1, hi);
    }

}
