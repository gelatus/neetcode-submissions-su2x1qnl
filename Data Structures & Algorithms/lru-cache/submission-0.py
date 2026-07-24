# Use a doubly linked list
class Node:
    def __init__(self, key, val):
        self.key, self.val = key, val
        self.prev = self.next = None


class LRUCache:
    def __init__(self, capacity: int):
        self.capacity = capacity
        self.cache = {}
        self.left, self.right = Node(0, None), Node(0, None)
        self.left.next = self.right
        self.right.prev = self.left
        

    def get(self, key: int) -> int:
        if key in self.cache:
            node = self.cache[key]
            self.remove(node)
            self.insert(node)
            return node.val
        return -1
        

    def put(self, key: int, value: int) -> None:
        if key in self.cache:
            self.remove(self.cache[key])

        node = Node(key,value)
        self.cache[key] = node
        self.insert(node)

        if len(self.cache) > self.capacity:
            # Remove the least used from the cache
            lru = self.left.next
            self.remove(lru)
            del self.cache[lru.key] # *GROK* This is how you remove from a hashmap in Python

   
   # Remove node from the list
    def remove(self, node):
        prev, next = node.prev, node.next
        prev.next = next
        next.prev = prev


    # Insert at rightmost position
    def insert(self, node):
        prev, next = self.right.prev, self.right
        prev.next = node
        next.prev = node
        node.next = next
        node.prev = prev
        
