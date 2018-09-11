/**
 * 19. Remove Nth Node From End of List
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/
 * Created by xialingpeng on 2018/9/5.
 */
public class leetcode_19 {
//    Given a linked list, remove the n-th node from the end of list and return its head.

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            if (head == null) return null;
            ListNode start = head;
            ListNode end = head;
            while (n > 0) {
                if (end != null) {
                    end = end.next;
                } else {
                    //n比链表长度长
                    return head;
                }
                n--;
            }
            //移除头部
            if (end == null) {
                head = head.next;
                return head;
            }
            while (end.next != null) {
                end = end.next;
                start = start.next;
            }
            start.next = start.next.next;
            return head;
        }
    }
}
