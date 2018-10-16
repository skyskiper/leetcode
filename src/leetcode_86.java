/**
 * 86. Partition List
 * https://leetcode.com/problems/partition-list/description/
 * Created by xialingpeng on 2018/9/27.
 */
public class leetcode_86 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    class Solution {
        public ListNode partition(ListNode head, int x) {
            ListNode lfHead = null, lfNode = null, riHead = null, riNode = null;
            while (head != null) {
                if (head.val >= x) {
                    if (riNode == null) {
                        riHead = riNode = head;
                    } else {
                        riNode.next = head;
                        riNode = head;
                    }
                } else {
                    if (lfNode == null) {
                        lfHead = lfNode = head;
                    } else {
                        lfNode.next = head;
                        lfNode = head;
                    }
                }
                head = head.next;
            }
            if (riNode != null) {
                riNode.next = null;
            }
            if (lfHead == null) {
                return riHead;
            }
            if (riHead != null) {
                lfNode.next = riHead;
            }
            return lfHead;
        }
    }
}
