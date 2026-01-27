package com.dsa.showcase.array.majority;

/*169. Majority Element
Solved
        Easy
Topics
premium lock icon
        Companies
Given an array nums of size n, return the majority element.

The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.



Example 1:

Input: nums = [3,2,3]
Output: 3
Example 2:

Input: nums = [2,2,1,1,1,2,2]
Output: 2*/
class MajorityElement1 {
    public static void main(String[] args) {
        MajorityElement1 solution = new MajorityElement1();
        int[] nums = {2, 2, 1, 1, 1, 2, 2};
        int result = solution.majorityElement(nums);
        System.out.println("The majority element is: " + result);
    }

    //time complexity O(n)
    //space complexity O(1)
    //algorithm Boyer-Moore Voting Algorithm
    public int majorityElement(int[] nums) {
        int candidate = 0;
        int count = 0;

        for (int num : nums) {
            if (candidate == num) {
                count++;
            } else if (count == 0) {
                candidate = num;
                count =1;
            } else {
                count--;
            }
        }
        count = 0;
        for (int num : nums) {
            if (num == candidate) {
                count++;
            }
        }
        return count > nums.length / 2 ? candidate : -1;
    }
}