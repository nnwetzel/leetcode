"""
There's a web server access log file at /home/admin/access.log. The file
consists of one line per HTTP request, with the requester's IP address at
the beginning of each line. Find the IP address that has the most requests
in this file (there is no tie; the IP is unique). Write the solution into
/home/admin/highestip.txt.
"""

from collections import Counter

counts = Counter()

# read /home/admin/access.log
with open('access.log', 'r') as f:
    for line in f:
        # extract IP address (first part of line)
        ip = line.split()[0]
        # count occurrences of each IP
        counts[ip] += 1

# find the IP with the highest count
# most_common(1) returns a list of the top 1 (element, count) tuples
top_ip, _ = counts.most_common(1)[0]

# write to /home/admin/highestip.txt
with open('highestip.txt', 'w') as out:
    # write the top IP address
    out.write(top_ip)