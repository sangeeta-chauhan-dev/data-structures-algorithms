package com.dsa.showcase.array.binarysearch.searchspace;
/*Find nth root of m
Difficulty: MediumAccuracy: 25.06%Submissions: 254K+Points: 4Average Time: 15m
You are given 2 numbers n and m, the task is to find n√m (nth root of m). If the root is not integer then return -1.

Examples :

Input: n = 3, m = 8
Output: 2
Explanation: 23 = 8
Input: n = 3, m = 9
Output: -1
Explanation: 3rd root of 9 is not integer.
        Input: n = 4, m = 16
Output: 2
Explanation: 24 = 16
Constraints:
        1 ≤ n ≤ 9
        0 ≤ m ≤ 20*/
class NthRoot {
    public int nthRoot(int n, int m) {

        if (m == 0) return 0;

        long low = 1;
        long high = m;

        while (low <= high) {

            long mid = low + (high - low) / 2;
            long val = power(mid, n, m);

            if (val == m) {
                return (int) mid;
            } 
            else if (val < m) {
                low = mid + 1;
            } 
            else {
                high = mid - 1;
            }
        }

        return -1;
    }

    // Early stopping power function
    private long power(long base, int exp, int limit) {
        long result = 1;

        while (exp-- > 0) {
            result *= base;

            if (result > limit) {
                return result; // stop early
            }
        }

        return result;
    }
}
