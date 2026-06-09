/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        ListNode dummy = new ListNode(0), tail = dummy;
        ListNode cur1 = list1, cur2 = list2;
        while (cur1 != null && cur2 != null) {
            if (cur1.val <= cur2.val) {
                tail.next = cur1;
                cur1 = cur1.next;
            } else if (cur2.val < cur1.val) {
                tail.next = cur2;
                cur2 = cur2.next;
            }

            tail = tail.next;
        }

        // Attach the remaining nodes
        if (cur1 != null) 
            tail.next = cur1;
        else
            tail.next = cur2;

        return dummy.next;
    }
}