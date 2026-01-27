package com.dsa.showcase.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class LeadersInArray {

    public static void main(String[] args) {
        LeadersInArray solution = new LeadersInArray();
        int[] nums = {16, 17, 4, 3, 5, 2};
        List<Integer> result = solution.leaders(nums);
        System.out.println("The leaders in the array are: " + result);
    }

    //algo: traverse from right to left, keep track of the maximum element seen so far
    //time complexity: O(n)
    //space complexity: O(1) excluding output list
    public List<Integer> leaders(int[] nums) {
        int n = nums.length;
        int rightMost = nums[n - 1];
        List<Integer> list = new ArrayList<>();

        list.add(rightMost);

        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] > rightMost) {
                rightMost = nums[i];
                list.add(rightMost);
            }
        }

        Collections.reverse(list);
        return list;
    }
}
