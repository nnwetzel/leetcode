import csv, math

G = 9.8  # gravitational constant
stride = {}  # stores stride length for bipedal dinosaurs

with open('dataset2.csv') as f:
    next(f)  # skip header line
    for name, stride_len, stance in csv.reader(f):
        if stance == 'bipedal':  # only include bipedal dinosaurs
            stride[name] = float(stride_len)  # store stride length as float

speeds = []  # list to store (speed, name) pairs

with open('dataset1.csv') as f:
    next(f)  # skip header line
    for name, leg_len, diet in csv.reader(f):
        if name in stride:  # only process dinosaurs that appear in both files
            leg = float(leg_len)
            # apply speed formula using stride and leg length
            speed = ((stride[name] / leg) - 1) * math.sqrt(leg * G)
            speeds.append((speed, name))  # add to list as (speed, name)

# sort by speed (highest first) and print dinosaur names
for _, name in sorted(speeds, reverse=True):
    print(name)