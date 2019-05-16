import java.util.ArrayList;
import java.util.Arrays;

/*
 * @lc app=leetcode id=51 lang=java
 *
 * [51] N-Queens
 */
class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> allResult = new ArrayList<>();
        solveNQueens(allResult, new int[n], n, 0, new String[n]);
        return allResult;
    }

    public void solveNQueens(List<List<String>> allResult, int[] position, int n, int index, String[] result) {
        if (index == n) {
            allResult.add(Arrays.asList(result.clone()));
            return;
        }
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
                char[] row = new char[n];
                Arrays.fill(row, '.');
                row[i] = 'Q';
                result[index] = new String(row);
                solveNQueens(allResult, position, n, index + 1, result);
            }
        }
    }
}
