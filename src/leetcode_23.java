/**
 * 23. Merge k Sorted Lists
 * https://leetcode.com/problems/merge-k-sorted-lists/description/
 * Created by xialingpeng on 2018/9/27.
 */
public class leetcode_23 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    class Solution {

        /**
         * todo：使用归并排序，效率更高
         * @param lists
         * @return
         */
        public ListNode mergeKLists(ListNode[] lists) {
            if (lists == null || lists.length <= 0) return null;
            ListNode head = null, node = null, tmp;
            while ((tmp = pop(lists)) != null) {
                if (node == null) {
                    head = node = tmp;
                } else {
                    node.next = tmp;
                    node = node.next;
                }
            }
            return head;
        }

        public ListNode pop(ListNode[] lists) {
            ListNode min = null;
            int index = -1;
            for (int i = 0; i < lists.length; i++) {
                ListNode list = lists[i];
                if (list != null) {
                    if (min == null || min.val > list.val) {
                        min = list;
                        index = i;
                    }
                }
            }
            if (min != null && index >= 0) {
                lists[index] = lists[index].next;
            }
            return min;
        }
    }
}
