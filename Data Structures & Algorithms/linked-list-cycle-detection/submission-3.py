# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def hasCycle(self, head: Optional[ListNode]) -> bool:
        slow, fast = head, head

        if head == None:
            return False

        while True:
            slow = slow.next
            fast = fast.next.next if fast.next else fast.next

            if fast == None:
                return False

            if slow == fast:
                return True
        