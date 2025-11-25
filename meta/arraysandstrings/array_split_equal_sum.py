"""
You're given an array made up of positive integers.
Split the given array into two smaller arrays where
the sums of each smaller array are equal. Print out the two smaller arrays.
"""

# Time: O(N) - single pass through the array
# Space: O(1) - only storing sums and indices
def split_subarrays(nums):
    # total sum of all elements
    total_sum = sum(nums)
    
    # if total is odd, cannot split into two equal integer sums
    if total_sum % 2 != 0:
        return None, None
    
    # target sum for each half
    target_sum = total_sum // 2
    current_sum = 0
    
    # build a running sum from the left and check for the target
    for i in range(len(nums)):
        current_sum += nums[i]
        
        # when running sum equals half the total, split after i
        if current_sum == target_sum:
            return nums[:i+1], nums[i+1:]
    
    # no valid split found
    return