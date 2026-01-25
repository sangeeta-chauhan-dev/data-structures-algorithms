package com.dsa.showcase.array.kadane;

import java.util.Arrays;

/*53. Maximum Subarray
Solved
        Medium
Topics
premium lock icon
        Companies
Given an integer array nums, find the subarray with the largest sum, and return its sum.



Example 1:

Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: The subarray [4,-1,2,1] has the largest sum 6.
Example 2:

Input: nums = [1]
Output: 1
Explanation: The subarray [1] has the largest sum 1.*/
class MaxSubArray {
    public static void main(String[] args) {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        MaxSubArray maximumSubArray = new MaxSubArray();
        System.out.println(maximumSubArray.maxSubArray(arr));
        maximumSubArray.printMaxSubArray(arr);

    }

    //algorithm Kadane's Algorithm
    //time complexity O(n)
    //space complexity O(1)
    public int maxSubArray(int[] nums) {
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int num : nums) {
            currSum = Math.max(currSum + num, num);
            maxSum = Math.max(maxSum, currSum);
        }
        return maxSum;
    }

    public void printMaxSubArray(int[] nums) {
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;
        int start = 0, end = 0, tempStart = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > currSum + nums[i]) {
                currSum = nums[i];
                tempStart = i;
            } else {
                currSum += nums[i];
            }

            if (currSum > maxSum) {
                maxSum = currSum;
                start = tempStart;
                end = i;
            }
        }
       //print subarray
        System.out.println("Maximum Subarray: " + Arrays.toString(Arrays.copyOfRange(nums, start, end + 1)));
    }
}