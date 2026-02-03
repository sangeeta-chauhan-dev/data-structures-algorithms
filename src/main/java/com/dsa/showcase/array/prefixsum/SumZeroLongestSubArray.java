package com.dsa.showcase.array.prefixsum;

import java.util.HashMap;
import java.util.Map;
/*Largest subarray with 0 sum
Difficulty: MediumAccuracy: 41.84%Submissions: 452K+Points: 4Average Time: 20m
Given an array arr[] containing both positive and negative integers, the task is to find the length of the longest subarray with a sum equals to 0.

Note: A subarray is a contiguous part of an array, formed by selecting one or more consecutive elements while maintaining their original order.

Examples:

Input: arr[] = [15, -2, 2, -8, 1, 7, 10, 23]
Output: 5
Explanation: The longest subarray with sum equals to 0 is [-2, 2, -8, 1, 7].
Input: arr[] = [2, 10, 4]
Output: 0
Explanation: There is no subarray with a sum of 0.
Input: arr[] = [1, 0, -4, 3, 1, 0]
Output: 5
Explanation: The longest subarray with sum equals to 0 is [0, -4, 3, 1, 0]
Constraints:
        1 ≤ arr.size() ≤ 106
        −103 ≤ arr[i] ≤ 103*/
class SumZeroLongestSubArray {
    public static void main(String[] args) {
        int[] nums = {1, -1, 2, -2, 3, -3, 4};
        SumZeroLongestSubArray solution = new SumZeroLongestSubArray();
        int result = solution.maxLength(nums);
        System.out.println("The maximum length of a subarray that sums to 0 is: " + result);
    }
    int maxLength(int nums[]) {
        int sum = 0, maxLen = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if (sum == 0) {
                maxLen = i + 1;
            }

            if (map.containsKey(sum)) {
                maxLen = Math.max(maxLen, i - map.get(sum));
            } else {
                map.put(sum, i); // store first occurrence only
            }
        }
        return maxLen;
    }
}
