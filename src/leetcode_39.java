import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 39. Combination Sum
 * https://leetcode.com/problems/combination-sum/description/
 * Created by xialingpeng on 2018/10/16.
 */
public class leetcode_39 {

    class Solution {

        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            if (candidates == null || candidates.length <= 0) return null;

            Arrays.sort(candidates);

            List<List<Integer>> ret = new ArrayList<>();
            List<Integer> tmp = new ArrayList<>();

            backtracking(candidates, target, 0, tmp, ret);

            return ret;
        }

        void backtracking(int[] candidates, int target, int index, List<Integer> tmp, List<List<Integer>> ret) {
            if (target == 0) {
                ret.add(new ArrayList<>(tmp));
                return;
            }

            for (int i = index; i < candidates.length && candidates[i] <= target; i++) {
                tmp.add(candidates[i]);
                backtracking(candidates, target - candidates[i], i, tmp, ret);
                tmp.remove(tmp.size() - 1);
            }
        }
    }
}
