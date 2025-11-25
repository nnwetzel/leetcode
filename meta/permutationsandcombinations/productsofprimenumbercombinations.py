"""
Given prime numbers, find all products of non-empty subsets.
"""

# Time: O(2^N) - all subsets generated
# Space: O(N) - recursion stack
def prime_product_subsets(primes):
    result = []

    def dfs(index, product):
        # base case: all primes considered for subset because index equals length
        if index == len(primes):
            # add product if not empty subset
            if product != 1:
                result.append(product)
            return
        
        # to form all subsets, we have two choices at each prime:
        # exclude current prime
        dfs(index + 1, product)
        # include current prime
        dfs(index + 1, product * primes[index])

    # start at index 0 and product 1 (any number times 1 is itself)
    dfs(0, 1)
    return result