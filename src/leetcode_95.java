import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 95. Unique Binary Search Trees II
 * https://leetcode.com/problems/unique-binary-search-trees-ii/description/
 * Created by xialingpeng on 2018/8/14.
 */
public class leetcode_95 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {

        private Map<String, List<TreeNode>> cache = new HashMap<>();

        public List<TreeNode> generateTrees(int n) {
            if (n <= 0) return new ArrayList<>();
            return generateTree(1, n);
        }

        private List<TreeNode> generateTree(int left, int right) {
            if (cache.get(left + "-" + right) != null) return cache.get(left + "-" + right);
            List<TreeNode> result = new ArrayList<>();
            if (left > right) {
                result.add(null);
                cache.put(left + "-" + right, result);
                return result;
            }
            for (int i = left; i <= right; i++) {
                List<TreeNode> leftList = generateTree(left, i - 1);
                List<TreeNode> rightList = generateTree(i + 1, right);
                for (TreeNode leftNode : leftList) {
                    for (TreeNode rightNode : rightList) {
                        TreeNode root = new TreeNode(i);
                        root.left = leftNode;
                        root.right = rightNode;
                        result.add(root);
                    }
                }
            }
            cache.put(left + "-" + right, result);
            return result;
        }
    }
}
