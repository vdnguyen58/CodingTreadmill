package com.vonguyen.leetcode.medium;

import com.vonguyen.leetcode.common.ListNode;

public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head1 = l1;
        ListNode head2 = l2;
        ListNode retHead = new ListNode(0);
        ListNode retTail = retHead;
        int sum = 0;
        while (head1 != null || head2 != null) {
            int x = (head1 == null) ? 0 : head1.val;
            int y = (head2 == null) ? 0 : head2.val;
            sum = x + y + sum;
            retTail.next = new ListNode(sum % 10);
            retTail = retTail.next;
            sum  = sum / 10;
            if (head1 != null)
                head1 = head1.next;
            if (head2 != null)
                head2 = head2.next;
        }
        if (sum == 1)
            retTail.next = new ListNode(1);

        return retHead.next;
    }
}
