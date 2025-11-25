"""
Return random fortune from file with delimiter "#".
"""

import random

def get_random_fortune(filename, delimiter="#"):

    chosen = None
    count = 0
    current_fortune = []

    with open(filename, 'r') as f:
        for line in f:
            # for each non-delimiter line, append to the current fortune block
            if line.strip() != delimiter:
                current_fortune.append(line)
            # when we hit the delimiter, we've completed a fortune block
            else:
                # only process if the block is not empty
                if current_fortune:
                    count += 1
                    # resevoir sampling: replace chosen with probability 1/count
                    if random.randint(1, count) == 1:
                        chosen = ''.join(current_fortune)
                # handle the case where the file does not end with a delimiter
                current_fortune = []

    # handle last fortune only if file doesn't end with delimiter
    if current_fortune:
        count += 1
        # same reservoir sampling logic for the final block
        if random.randint(1, count) == 1:
            chosen = ''.join(current_fortune)
    
    return chosen

print(get_random_fortune("fortunes.txt"))