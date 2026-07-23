# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:

        # First, compute the sum of the two numbers
        p1, p2 = l1, l2
        dummy = ListNode()
        p3 = dummy
        carry = 0
        while p1 or p2 or carry:
            val = 0
            if p1:
                val += p1.val
                p1 = p1.next

            if p2:
                val += p2.val
                p2 = p2.next

            if carry > 0:
                val += carry
                carry = 0

            if val >= 10:
                val = val - 10
                carry = 1

            p3.next = ListNode(val)
            p3 = p3.next

        return dummy.next
        