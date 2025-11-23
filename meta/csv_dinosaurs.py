import csv
import math

G = 9.8

# name -> stride for bipedal dinos
stride = {}
with open('dataset2.csv', newline='') as f:
    reader = csv.reader(f)
    next(reader)
    for name, stride_length, stance in reader:
        if stance == 'bipedal':
            stride[name] = float(stride_length)

# compute speeds for dinos that appear in both files
speeds = []
with open('dataset1.csv', newline='') as f:
    reader = csv.reader(f)
    next(reader)
    for name, leg_length, _ in reader:
        if name in stride:
            leg = float(leg_length)
            speed = ((stride[name] / leg) - 1) * math.sqrt(leg * G)
            speeds.append((speed, name))

# print names sorted by speed descending
for _, name in sorted(speeds, reverse=True):
    print(name)