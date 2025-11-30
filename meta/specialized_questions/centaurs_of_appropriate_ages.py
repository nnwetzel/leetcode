"""
A group of centaurs (mythical half-human, half-horse creatures) all sign up for
Facebook at the same time. They immediately begin sending each other friend
requests, following the ancient rules that have governed centaur friendship
since the dawn of time:

1. A centaur will only send a friend request to another centaur if the
   recipient is at least (X / 2 + 7) years old, where X is the sender's age.
   Example: A 200-year-old centaur can only send requests to centaurs who are
   at least 107 years old.

2. A centaur will not send a friend request to another centaur that is older
   than itself.

3. A centaur over 100 years old will not send a friend request to a recipient
   under 100 years old. Centaurs under 100 years old may freely friend each other.

4. If any of the above conditions are violated, the friend request is not sent.

Given an array of centaur ages, return the total number of friend requests sent
within the group. Requests are directional (A → B counts separately from B → A),
and a centaur never sends a request to itself.
"""

from typing import List

def numFriendRequests(ages: List[int]) -> int:
    # histogram for ages up to max age in input
    max_age = max(ages)
    age_count = [0] * (max_age + 1)
    for age in ages:
        age_count[age] += 1

    total_requests = 0

    # iterate through all age pairs
    for age_a in range(1, max_age + 1):
        count_a = age_count[age_a]
        # skip if no one of this age
        if count_a == 0:
            continue

        for age_b in range(1, max_age + 1):
            count_b = age_count[age_b]
            # skip if no one of this age
            if count_b == 0:
                continue

            # 1) recipient at least age_a / 2 + 7
            if age_b < age_a / 2 + 7:
                continue
            # 2) recipient not older than sender
            if age_b > age_a:
                continue
            # 3) sender > 100 cannot send to recipient < 100
            if age_a > 100 and age_b < 100:
                continue
            
            # if both ages are the same, each person can send requests to (count - 1) others
            if age_a == age_b:
                total_requests += count_a * (count_a - 1)
            # if different ages, each person of age A can send requests to all of age B
            else:
                total_requests += count_a * count_b
    return total_requests