# Time: O(1) for get and put operations
# Space: O(capacity) for storing cache items
class LRUCache:

    def __init__(self, capacity: int):
        self.capacity = capacity
        # ordered dict to maintain LRU order
        self.odict = {}

    def get(self, key: int) -> int:
        # return -1 if key not found
        if key not in self.odict:
            return -1
        
        # move key to end to mark as recently used
        self.odict[key] = self.odict.pop(key)
        # return the value
        return self.odict[key]
        
    def put(self, key: int, value: int) -> None:
        # if key exists, remove it first
        self.odict.pop(key, None)
        # insert key-value pair as most recently used
        self.odict[key] = value

        # if over capacity, remove least recently used item
        if len(self.odict) > self.capacity:
            self.odict.pop(next(iter(self.odict)))
        
# Your LRUCache object will be instantiated and called as such:
# obj = LRUCache(capacity)
# param_1 = obj.get(key)
# obj.put(key,value)