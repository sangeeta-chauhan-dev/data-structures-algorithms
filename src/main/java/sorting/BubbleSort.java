package sorting;

public class BubbleSort {
    public static void main(String[] args) {
        BubbleSort bubbleSort = new BubbleSort();
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        bubbleSort.bubbleSort(arr);
        System.out.println("Sorted array: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    //algorithm bubble sort
    //time complexity O(n^2)
    //space complexity O(1)
    void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapOccurred=false;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swapOccurred = true;
                    swap(arr, j, j + 1);
                }
            }
            if (!swapOccurred) {
                break;
            }
        }
    }

    void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
