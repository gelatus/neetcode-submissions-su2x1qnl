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

        ListNode list3 = null, cur3 = null;
        ListNode cur1 = list1, cur2 = list2;
        while (cur1 != null || cur2 != null) {
            if (cur3 == null) {
                cur3 = new ListNode();
                list3 = cur3;
            } else {
                cur3.next = new ListNode();
                cur3 = cur3.next;
            }

            if (cur1 == null) {
                cur3.val = cur2.val;
                cur2 = cur2.next; 
            } else if (cur2 == null) {
                cur3.val = cur1.val;
                cur1 = cur1.next;
            } else {
                if (cur1.val <= cur2.val) {
                    cur3.val = cur1.val;
                    cur1 = cur1.next;
                } else if (cur2.val < cur1.val) {
                    cur3.val = cur2.val;
                    cur2 = cur2.next;
                }
            }
        }

        return list3;
    }
}