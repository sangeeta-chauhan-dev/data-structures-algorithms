package com.dsa.showcase.array.matrix;

import java.util.ArrayList;
import java.util.List;
/*118. Pascal's Triangle
Solved
        Easy
Topics
premium lock icon
        Companies
Given an integer numRows, return the first numRows of Pascal's triangle.

In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:




Example 1:

Input: numRows = 5
Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
Example 2:

Input: numRows = 1
Output: [[1]]


Constraints:

        1 <= numRows <= 30*/
class PascalTriangle {
    public static void main(String[] args) {
        PascalTriangle solution = new PascalTriangle();
        int numRows = 5;
        List<List<Integer>> result = solution.generate(numRows);
        System.out.println("Pascal's Triangle with " + numRows + " rows:");
        for (List<Integer> row : result) {
            System.out.println(row);
        }
    }

    //time complexity O(n^2)
    //space complexity O(n^2)
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();

        for (int row = 0; row < numRows; row++) {
            List<Integer> list = new ArrayList<>(row + 1);
            list.add(1);

            if (row > 0) {
                List<Integer> prev = result.get(row - 1);
                for (int i = 1; i < row; i++) {
                    list.add(prev.get(i - 1) + prev.get(i));
                }
                list.add(1);
            }

            result.add(list);
        }
        return result;
    }
}
