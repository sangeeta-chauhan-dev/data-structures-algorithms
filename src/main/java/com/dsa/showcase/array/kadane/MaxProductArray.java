package com.dsa.showcase.array.kadane;

/*152. Maximum Product Subarray
        Solved
Medium
        Topics
premium lock icon
        Companies
Given an integer array nums, find a subarray that has the largest product, and return the product.

The test cases are generated so that the answer will fit in a 32-bit integer.

Note that the product of an array with a single element is the value of that element.



        Example 1:

Input: nums = [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.
Example 2:

Input: nums = [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.


Constraints:

        1 <= nums.length <= 2 * 104
        -10 <= nums[i] <= 10
The product of any subarray of nums is guaranteed to fit in a 32-bit integer.*/
class MaxProductArray {

    public static void main(String[] args) {
        int[] arr = {2, 3, -2, 4};
        MaxProductArray maxProductArray = new MaxProductArray();
        System.out.println(maxProductArray.maxProduct(arr));
    }

    //algorithm Modified Kadane's Algorithm
    //time complexity O(n)
    //space complexity O(1)
    public int maxProduct(int[] nums) {
        //max product can be negative, so we need to keep track of both max and min
        int min = 1;
        int max = 1;
        int res = Integer.MIN_VALUE;
        for (int num : nums) {
            // when num is negative, max and min will swap
            //because negative * negative = positive and negative * positive = negative
            if (num < 0) {
                int temp = min;
                min = max;
                max = temp;
            }
            max = Math.max(max * num, num);
            min = Math.min(min * num, num);
            res = Math.max(res, max);
        }
        return res;
    }
}