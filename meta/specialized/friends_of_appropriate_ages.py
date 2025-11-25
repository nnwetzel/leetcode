from ast import List

class Solution:
    def numFriendRequests(self, ages: List[int]) -> int:
        # list of counts for ages 1 to 120
        age_count = [0] * 121
        # increment counts for each age
        for age in ages:
            age_count[age] += 1

        total_requests = 0

        # iterate through all age pairs
        for age_a in range(1, 121):
            count_a = age_count[age_a]
            # skip if no one of this age
            if count_a == 0:
                continue
            
            for age_b in range(1, 121):
                count_b = age_count[age_b]
                # skip if no one of this age
                if count_b == 0:
                    continue
                
                # check conditions for valid friend request
                if age_b <= 0.5 * age_a + 7:
                    continue
                if age_b > age_a:
                    continue
                # third condition is redundant
                
                # if both ages are the same, each person can send requests to (count - 1) others
                if age_a == age_b:
                    total_requests += count_a * (count_a - 1)
                # if different ages, each person of age A can send requests to all of age B
                else:
                    total_requests += count_a * count_b
        return total_requests