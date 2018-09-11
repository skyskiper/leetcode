/**
 * 2. Add Two Numbers
 * https://leetcode.com/problems/add-two-numbers/description/
 * Created by xialingpeng on 2018/9/5.
 */
public class leetcode_2 {

//    You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
//
//    You may assume the two numbers do not contain any leading zero, except the number 0 itself.

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode result = null, tmp = null;
            int sum, carry = 0;
            while (l1 != null || l2 != null || carry != 0) {
                if (l1 != null && l2 != null) {
                    sum = l1.val + l2.val + carry;
                    if (sum >= 10) {
                        carry = 1;
                        sum = sum - 10;
                    } else {
                        carry = 0;
                    }
                    if (tmp == null) {
                        tmp = result = new ListNode(sum);
                    } else {
                        tmp.next = new ListNode(sum);
                        tmp = tmp.next;
                    }
                    l1 = l1.next;
                    l2 = l2.next;
                } else if (l1 != null) {
                    sum = l1.val + carry;
                    if (sum >= 10) {
                        carry = 1;
                        sum = sum - 10;
                    } else {
                        carry = 0;
                    }
                    if (tmp == null) {
                        tmp = result = new ListNode(sum);
                    } else {
                        tmp.next = new ListNode(sum);
                        tmp = tmp.next;
                    }
                    l1 = l1.next;
                } else if (l2 != null) {
                    sum = l2.val + carry;
                    if (sum >= 10) {
                        carry = 1;
                        sum = sum - 10;
                    } else {
                        carry = 0;
                    }
                    if (tmp == null) {
                        tmp = result = new ListNode(sum);
                    } else {
                        tmp.next = new ListNode(sum);
                        tmp = tmp.next;
                    }
                    l2 = l2.next;
                } else {
                    tmp.next = new ListNode(carry);
                    tmp = tmp.next;
                    carry = 0;
                }
            }
            return result;
        }
    }
}
