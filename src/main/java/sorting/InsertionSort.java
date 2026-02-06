package sorting;

class InsertionSort {
    public static void main(String[] args) {
        InsertionSort insertionSort = new InsertionSort();
        int[] arr = {12, 11, 13, 5, 6};
        insertionSort.insertionSort(arr);
        System.out.println("Sorted array: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    //algorithm insertion sort
    //time complexity O(n^2)
    //space complexity O(1)
    public void insertionSort(int arr[]) {
        // code here
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int ele = arr[i];
            int j = i - 1;
            while (j >= 0 && ele < arr[j]) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = ele;
        }

    }
}