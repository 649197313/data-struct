package com.nick.sort;

import java.util.Arrays;
import java.util.Random;

public class Sort {

    public static void main(String[] args) {
//        int[] arr = {6, 1, 8, 12, 72, 5, 36};
        int[] arr = {10, 80, 24, 52, 49, 22, 57, 9, 89, 50, 67, 21, 38, 77, 44, 49, 70, 33, 95, 97, 58, 57, 64, 49, 78, 30, 60, 86, 58, 86};
//        int[] arr = {10, 80, 24, 52, 49, 22, 57, 9, 50, 21};
//        int[] arr = {10, 9, 21};
        quickSort(arr, 0, arr.length - 1);
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
