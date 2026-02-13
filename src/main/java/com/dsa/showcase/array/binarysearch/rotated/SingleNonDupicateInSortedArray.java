package com.dsa.showcase.array.binarysearch.rotated;

/*540. Single Element in a Sorted Array
Solved
        Medium
Topics
premium lock icon
        Companies
You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once.

Return the single element that appears only once.

Your solution must run in O(log n) time and O(1) space.



        Example 1:

Input: nums = [1,1,2,3,3,4,4,8,8]
Output: 2
Example 2:

Input: nums = [3,3,7,7,10,11,11]
Output: 10


Constraints:

        1 <= nums.length <= 105
        0 <= nums[i] <= 105*/
class SingleNonDupicateInSortedArray {
    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 3, 3, 4, 4, 8, 8};
        SingleNonDupicateInSortedArray singleNonDupicateInSortedArray = new SingleNonDupicateInSortedArray();
        int result = singleNonDupicateInSortedArray.singleNonDuplicate(nums);
        System.out.println("The single non-duplicate element is: " + result);
    }
    //trick is to make mid even and compare with next element
    //time complexity is O(log n)
    //space complexity is O(1)
    public int singleNonDuplicate(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (mid % 2 != 0) mid--;
            if (nums[mid] == nums[mid + 1]) {
                left = mid + 2;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }
}