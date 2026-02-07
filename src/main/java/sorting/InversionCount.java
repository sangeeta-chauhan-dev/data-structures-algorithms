package sorting;
/*Count Inversions
Difficulty: MediumAccuracy: 16.93%Submissions: 741K+Points: 4
Given an array of integers arr[]. You have to find the Inversion Count of the array.
Note : Inversion count is the number of pairs of elements (i, j) such that i < j and arr[i] > arr[j].

Examples:

Input: arr[] = [2, 4, 1, 3, 5]
Output: 3
Explanation: The sequence 2, 4, 1, 3, 5 has three inversions (2, 1), (4, 1), (4, 3).
Input: arr[] = [2, 3, 4, 5, 6]
Output: 0
Explanation: As the sequence is already sorted so there is no inversion count.
Input: arr[] = [10, 10, 10]
Output: 0
Explanation: As all the elements of array are same, so there is no inversion count.
        Constraints:
        1 ≤ arr.size() ≤ 105
        1 ≤ arr[i] ≤ 104*/
class InversionCount {
    static int inversionCount(int arr[]) {
        return mergeSort(arr, 0, arr.length - 1);

    }

    // Function to count inversions in the array.
    // time complexity: O(n log n) as we are using merge sort
    // space complexity: O(n) as we are using temporary arrays to merge the two halves
    static int mergeSort(int arr[], int l, int r) {
        // code here
        int count = 0;
        if (l < r) {
            int m = l + (r - l) / 2;
            count += mergeSort(arr, l, m);
            count += mergeSort(arr, m + 1, r);
            count += merge(arr, l, m, r);
        }
        return count;
    }

    static int merge(int arr[], int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;
        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];
        for (int i = 0; i < n1; i++) {
            leftArr[i] = arr[l + i];
        }
        for (int i = 0; i < n2; i++) {
            rightArr[i] = arr[m + 1 + i];
        }
        int k = l;
        int i = 0;
        int j = 0;
        int count = 0;
        while (i < n1 && j < n2) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k++] = leftArr[i++];
            } else {
                arr[k++] = rightArr[j++];
                count += n1 - i;
            }
        }
        while (i < n1) {
            arr[k++] = leftArr[i++];
        }
        while (j < n2) {
            arr[k++] = rightArr[j++];
        }
        return count;
    }
}