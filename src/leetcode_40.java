import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 40. Combination Sum II
 * https://leetcode.com/problems/combination-sum-ii/
 * Created by xialingpeng on 2018/10/16.
 */
public class leetcode_40 {

    class Solution {
        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            if (candidates == null || candidates.length < 1) return null;

            Arrays.sort(candidates);

            List<List<Integer>> ret = new ArrayList<>();
            List<Integer> tmp = new ArrayList<>();

            backtrack(candidates, target, 0, ret, tmp);
            return ret;
        }

        void backtrack(int[] candidates, int target, int pos, List<List<Integer>> ret, List<Integer> tmp) {
            if (target == 0) {
                ret.add(new ArrayList<>(tmp));
                return;
            }
            for (int i = pos; i < candidates.length && candidates[i] <= target; i++) {
                if (i > pos && candidates[i] == candidates[i - 1]) continue;
                tmp.add(candidates[i]);
                backtrack(candidates, target - candidates[i], i + 1, ret, tmp);
                tmp.remove(tmp.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new leetcode_40().new Solution();
        int[] input = {10, 1, 2, 7, 6, 1, 5};

        for (List<Integer> integers : solution.combinationSum2(input, 8)) {
            for (Integer integer : integers) {
                System.out.print(integer + " -");
            }
            System.out.println();
        }

    }
}
