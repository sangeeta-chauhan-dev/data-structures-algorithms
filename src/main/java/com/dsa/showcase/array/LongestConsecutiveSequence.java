package com.dsa.showcase.array;

import java.util.HashSet;
import java.util.Set;
/*128. Longest Consecutive Sequence
        Solved
Medium
        Topics
premium lock icon
        Companies
Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.

You must write an algorithm that runs in O(n) time.



Example 1:

Input: nums = [100,4,200,1,3,2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
Example 2:

Input: nums = [0,3,7,2,5,8,4,6,0,1]
Output: 9
Example 3:

Input: nums = [1,0,1,2]
Output: 3


Constraints:

        0 <= nums.length <= 105
        -109 <= nums[i] <= 109*/
class LongestConsecutiveSequence {
    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};
        LongestConsecutiveSequence lcs = new LongestConsecutiveSequence();
        int result = lcs.longestConsecutive(nums);
        System.out.println("Length of the longest consecutive elements sequence: " + result);
    }
    //algorithm HashSet
    //time complexity O(n)
    //space complexity O(n)
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;

        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int max = 0;

        for (int num : set) {
            if (!set.contains(num - 1)) {
                int curr = num;
                int count = 1;

                while (set.contains(curr + 1)) {
                    curr++;
                    count++;
                }

                max = Math.max(max, count);
            }
        }
        return max;
    }
}
