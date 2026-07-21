# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def removeNthFromEnd(self, head: Optional[ListNode], n: int) -> Optional[ListNode]:
        # First find the length of the list
        length = 0
        cur = head
        while cur:
            length += 1
            cur = cur.next

        # Now that we know the length of the list, 
        # we use it to find the n'th node from the end
        # which is the same as the (length - n)th node 
        # from the front
        dummy = ListNode(-1,head)
        cur = dummy
        for _ in range(length - n):
            cur = cur.next

        # Sever the node from the list
        cur.next = cur.next.next

        return dummy.next


        