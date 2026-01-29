package com.dsa.showcase.array.matrix;

import java.util.LinkedList;
import java.util.Queue;

/*73. Set Matrix Zeroes
        Solved
Medium
        Topics
premium lock icon
        Companies
Hint
Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.

You must do it in place.



        Example 1:


Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
Output: [[1,0,1],[0,0,0],[1,0,1]]
Example 2:


Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]


Constraints:

m == matrix.length
n == matrix[0].length
1 <= m, n <= 200
        -231 <= matrix[i][j] <= 231 - 1


Follow up:

A straightforward solution using O(mn) space is probably a bad idea.
A simple improvement uses O(m + n) space, but still not the best solution.
Could you devise a constant space solution?*/
class SetZeroesSolution {
    public static void main(String[] args) {
        SetZeroesSolution solution = new SetZeroesSolution();
        int[][] matrix = {
                {0, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        };
        solution.setZeroesOptimal(matrix);
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    //algorithm using BFS
    //time complexity O(m*n)
    //space complexity O(m*n)
    public void setZeroes(int[][] matrix) {
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    queue.add(new int[]{i, j});
                }
            }
        }
        while (!queue.isEmpty()) {
            int[] arr = queue.remove();
            int row = arr[0];
            int col = arr[1];
            for (int j = 0; j < matrix[row].length; j++) {
                matrix[row][j] = 0;
            }
            for (int j = 0; j < matrix.length; j++) {
                matrix[j][col] = 0;
            }
        }
    }

    //algorithm optimal approach
    //time complexity O(m*n)
    //space complexity O(1)
    public void setZeroesOptimal(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int row0 = 1, col0 = 1;

        // Check first row
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) row0 = 0;
        }

        // Check first column
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) col0 = 0;
        }

        // Mark zeros
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // Zero inner matrix
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // Zero first row
        if (row0 == 0) {
            for (int j = 0; j < n; j++) matrix[0][j] = 0;
        }

        // Zero first column
        if (col0 == 0) {
            for (int i = 0; i < m; i++) matrix[i][0] = 0;
        }
    }
}