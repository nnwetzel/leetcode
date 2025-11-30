"""
You will be supplied with two data files in CSV format.
The first file contains statistics about various dinosaurs. The second file contains additional data.
Given the following formula, speed = ((STRIDE_LENGTH / LEG_LENGTH) - 1) * SQRT(LEG_LENGTH * g)
Where g = 9.8 m/s^2 (gravitational constant)

Write a program to read in the data files from disk, it must then print the names of only the
bipedal dinosaurs from fastest to slowest. Do not print any other information.
"""
import csv
import math

G = 9.8

def find_bipedal_speeds(dataset1, dataset2):
    # map: name -> stride length for bipedal dinosaurs only
    stride = {}
    with open(dataset2, newline="") as f:
        reader = csv.DictReader(f)
        # for each dinosaur, if bipedal, store stride length
        for row in reader:
            if row['STANCE'] == 'bipedal':
                stride[row['NAME']] = float(row['STRIDE_LENGTH'])

    # list of (speed, name) tuples
    speeds = []

    # compute speed for dinos that appear in both files
    with open(dataset1, newline="") as f:
        reader = csv.DictReader(f)
        # for each dinosaur, if in stride dict, compute speed
        for row in reader:
            if row['NAME'] in stride:
                leg = float(row['LEG_LENGTH'])
                speed = ((stride[row['NAME']] / leg) - 1) * math.sqrt(leg * G)
                # store (speed, name) tuple
                speeds.append((speed, row['NAME']))

    # fastest to slowest (descending order)
    speeds.sort(reverse=True)
    # print names only
    for _, name in speeds:
        print(name)

# print names only
find_bipedal_speeds("dataset1.csv", "dataset2.csv")

# Interview follow-ups:
# 1. One file small, one large: Load small files in memory, stream large file.
# 2. Both files large: Use external sorting or MapReduce (to join datasets).
# 3. Empty files: Check file existence and size before processing.
# 4. Frequent updates: Implement caching with file modification time checks.