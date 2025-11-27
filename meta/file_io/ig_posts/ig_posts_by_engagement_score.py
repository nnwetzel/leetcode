"""
You are given a CSV file containing Instagram post data with the following
columns: username, post_id, likes, comments, and shares. Compute an engagement
score for each post using the formula:

    engagementScore = (likes^1.2 + comments^1.3 + shares^1.4) / 3

Then determine the top 10 posts with the highest scores and output their
post_id along with the computed engagement score, sorted in descending order.
"""

import csv

def top_10_engagement_posts(file_name):
    results = []

    with open(file_name, newline='') as f:
        reader = csv.DictReader(f)
        for row in reader:
            # extract likes, comments, shares as integers
            likes = int(row['LIKES'])
            comments = int(row['COMMENTS'])
            shares = int(row['SHARES'])

            engagement_score = (likes ** 1.2 + comments ** 1.3 + shares ** 1.4) / 3
            # store (engagement_score, post_id) tuple
            results.append((engagement_score, row['POST_ID']))

    # sort by engagement score (descending)
    results.sort(reverse=True)
    # print top 10 posts
    for score, post_id in results[:10]:
        print(f"Post ID: {post_id}, Engagement Score: {score:.2f}")

top_10_engagement_posts('posts.csv')