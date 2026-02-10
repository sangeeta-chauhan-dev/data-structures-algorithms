package com.dsa.showcase.sorting;

/*493. Reverse Pairs
Solved
        Hard
Topics
premium lock icon
        Companies
Hint
Given an integer array nums, return the number of reverse pairs in the array.

A reverse pair is a pair (i, j) where:

        0 <= i < j < nums.length and
nums[i] > 2 * nums[j].


Example 1:

Input: nums = [1,3,2,3,1]
Output: 2
Explanation: The reverse pairs are:
        (1, 4) --> nums[1] = 3, nums[4] = 1, 3 > 2 * 1
        (3, 4) --> nums[3] = 3, nums[4] = 1, 3 > 2 * 1
Example 2:

Input: nums = [2,4,3,5,1]
Output: 3
Explanation: The reverse pairs are:
        (1, 4) --> nums[1] = 4, nums[4] = 1, 4 > 2 * 1
        (2, 4) --> nums[2] = 3, nums[4] = 1, 3 > 2 * 1
        (3, 4) --> nums[3] = 5, nums[4] = 1, 5 > 2 * 1


Constraints:

        1 <= nums.length <= 5 * 104
        -231 <= nums[i] <= 231 - 1*/
class ReversePairs {
    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    //time complexity: O(n log n)
    //space complexity: O(n)
    int mergeSort(int arr[], int l, int r) {
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

    int merge(int arr[], int l, int m, int r) {
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
        int i = 0;
        int j = 0;
        int count = 0;
        while (i < n1 && j < n2) {
            if (leftArr[i] > 2L * rightArr[j]) {
                count += n1 - i;
                j++;
            } else {
                i++;
            }
        }
        int k = l;
        i = 0;
        j = 0;
        while (i < n1 && j < n2) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k++] = leftArr[i++];
            } else {
                arr[k++] = rightArr[j++];
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