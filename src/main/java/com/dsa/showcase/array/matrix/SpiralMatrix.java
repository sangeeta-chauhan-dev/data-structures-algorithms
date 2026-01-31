package com.dsa.showcase.array.matrix;

import java.util.ArrayList;
import java.util.List;

/*54. Spiral Matrix
Solved
        Medium
Topics
premium lock icon
        Companies
Hint
Given an m x n matrix, return all elements of the matrix in spiral order.



Example 1:


Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,3,6,9,8,7,4,5]
Example 2:


Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]


Constraints:

m == matrix.length
n == matrix[i].length
1 <= m, n <= 10
        -100 <= matrix[i][j] <= 100*/
class SpiralMatrix {

    public static void main(String[] args) {
        SpiralMatrix solution = new SpiralMatrix();
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        List<Integer> result = solution.spiralOrder(matrix);
        System.out.println(result); // Output: [1, 2, 3, 6, 9, 8, 7, 4, 5]
    }

    //algorithm is to traverse the matrix in spiral order
    // 4 pointers topRow, bottomRow, leftCol, rightCol
    //time complexity O(m*n)
    //space complexity O(1)
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int topRow = 0;
        int leftCol = 0;
        int rightCol = n - 1;
        int bottomRow = m - 1;
        List<Integer> list = new ArrayList<>();
        while (topRow <= bottomRow && leftCol <= rightCol) {

            for (int i = leftCol; i <= rightCol; i++) {
                list.add(matrix[topRow][i]);
            }
            topRow++;
            for (int i = topRow; i <= bottomRow; i++) {
                list.add(matrix[i][rightCol]);
            }
            rightCol--;
            //to avoid double counting of rows and columns
            if (topRow <= bottomRow) {
                for (int i = rightCol; i >= leftCol; i--) {
                    list.add(matrix[bottomRow][i]);
                }
                bottomRow--;
            }
            //to avoid double counting of rows and columns
            if (leftCol <= rightCol) {
                for (int i = bottomRow; i >= topRow; i--) {
                    list.add(matrix[i][leftCol]);
                }
                leftCol++;
            }


        }
        return list;
    }
}