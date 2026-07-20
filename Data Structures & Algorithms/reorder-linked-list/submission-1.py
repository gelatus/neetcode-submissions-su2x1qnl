# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
        slow, fast = head, head

        # Use slow and fast pointers to find mid point
        while  fast and fast.next:
            slow = slow.next
            fast = fast.next.next

        # slow should now point to the middle of the list
        # now we proceed to reverse the seonc half of this list
        curr = slow.next
        slow.next = None
        head2 = None

        while curr:
            temp = curr.next
            curr.next = head2
            head2 = curr
            curr = temp

        # Now, merge the original list with the new reversed list
        # Stop when we reach the end of list 2
        l1, l2 = head, head2
        while l2:
            l1_next = l1.next
            l2_next = l2.next
            l1.next = l2
            l2.next = l1_next;
            l1 = l1_next
            l2 = l2_next
            
