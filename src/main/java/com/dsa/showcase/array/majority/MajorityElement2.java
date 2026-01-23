package com.dsa.showcase.array.majority;

import java.util.ArrayList;
import java.util.List;
/*229. Majority Element II
        Solved
Medium
        Topics
premium lock icon
        Companies
Hint
Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.



        Example 1:

Input: nums = [3,2,3]
Output: [3]
Example 2:

Input: nums = [1]
Output: [1]
Example 3:

Input: nums = [1,2]
Output: [1,2]


Constraints:

        1 <= nums.length <= 5 * 104
        -109 <= nums[i] <= 109


Follow up: Could you solve the problem in linear time and in O(1) space?*/
class MajorityElement2 {
    public static void main(String[] args) {
        MajorityElement2 solution = new MajorityElement2();
        int[] nums = {3, 2, 3};
        List<Integer> result = solution.majorityElement(nums);
        System.out.println("The majority elements are: " + result);
    }

    //time complexity O(n)
    //space complexity O(1)
    //algorithm Boyer-Moore Voting Algorithm
    public List<Integer> majorityElement(int[] nums) {
        int candidate1 = 0;
        int candidate2 = 0;
        int count1 = 0;
        int count2 = 0;
        for (int num : nums) {
            if (count1 > 0 && candidate1 == num) {
                count1++;
            } else if (count2 > 0 && candidate2 == num) {
                count2++;
            } else if (count1 == 0) {
                candidate1 = num;
                count1 = 1;
            } else if (count2 == 0) {
                candidate2 = num;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }
        count1 = 0;
        count2 = 0;
        for (int num : nums) {
            if (candidate1 == num) {
                count1++;
            } else if (candidate2 == num) {
                count2++;
            }
        }
        List<Integer> result = new ArrayList<>();
        if (count1 > nums.length / 3) result.add(candidate1);
        if (count2 > nums.length / 3) result.add(candidate2);

        return result;
    }
}