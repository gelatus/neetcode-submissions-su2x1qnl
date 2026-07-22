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
        dummy = Node(0, None, None)

        # First pass, copy the node values
        # and link the new nodes. Map old
        # node with new node
        cur, cur2 = head, dummy
        while cur:
            tmp = Node(cur.val)
            nodeMap[cur] = tmp
            cur2.next = tmp
            cur2 = cur2.next
            cur = cur.next

        # Now fix the random links, based on the 
        # node map
        cur, cur2 = head, dummy.next
        while cur:
            if cur.random:
                cur2.random = nodeMap[cur.random]
            cur = cur.next
            cur2 = cur2.next

        return dummy.next



        