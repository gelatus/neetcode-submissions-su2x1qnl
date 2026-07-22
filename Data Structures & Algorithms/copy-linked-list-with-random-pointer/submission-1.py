"""
# Definition for a Node.
class Node:
    def __init__(self, x: int, next: 'Node' = None, random: 'Node' = None):
        self.val = int(x)
        self.next = next
        self.random = random
"""

class Solution:
    def copyRandomList(self, head: 'Optional[Node]') -> 'Optional[Node]':
        if not head:
            return None

        nodeMap = {}

        # First pass, just create the copies
        # Map old node to the new copy
        # Don't connect anything yet
        cur = head
        while cur:
            tmp = Node(cur.val)
            nodeMap[cur] = tmp
            cur = cur.next

        # Now fix the links, based on the node map
        cur = head
        while cur:
            cur2 = nodeMap[cur]
            if cur.next:
                cur2.next = nodeMap[cur.next]
            
            if cur.random:
                cur2.random = nodeMap[cur.random]
            
            cur = cur.next

        return nodeMap[head]



        