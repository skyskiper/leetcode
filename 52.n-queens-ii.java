/*
 * @lc app=leetcode id=52 lang=java
 *
 * [52] N-Queens II
 */
class Solution {

    public int totalNQueens(int n) {
        return solveNQueens(new int[n], n, 0);
    }

    public int solveNQueens(int[] position, int n, int index) {
        if (index == n) {
            return 1;
        }
        int num = 0;
        for (int i = 0; i < n; i++) {
            position[index] = i;
            boolean conflict = false;
            for (int j = 0; j < index; j++) {
                if (position[j] == position[index] || Math.abs(index - j) == Math.abs(position[j] - position[index])) {
                    conflict = true;
                    break;
                }
            }
            if (!conflict) {
                num += solveNQueens(position, n, index + 1);
            }
        }
        return num;
    }
}
