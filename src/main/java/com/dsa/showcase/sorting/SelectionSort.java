package com.dsa.showcase.sorting;

class SelectionSort {
    public static void main(String[] args) {
        SelectionSort selectionSort = new SelectionSort();
        int[] arr = {64, 25, 12, 22, 11};
        selectionSort.selectionSort(arr);
        System.out.println("Sorted array: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    //algorithm selection sort
    //time complexity O(n^2)
    //space complexity O(1)
    void selectionSort(int[] arr) {
        // code here
        for (int i = 0; i < arr.length; i++) {
            int ind = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[ind] > arr[j]) {
                    ind = j;
                }
            }
            if (i != ind) {
                swap(arr, ind, i);
            }
        }
    }

    void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}