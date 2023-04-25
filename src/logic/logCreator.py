import sys
import random

seed = random.getrandbits(32)

def uniqueid():
    seed = random.getrandbits(32)
    while True:
       yield seed
       seed += 1

uniqueid()

file = open("src/logs/log-"+str(seed)+".txt", "w")
for word in sys.argv:

    if word == 'src\logic\logCreator.py':
        print("No")

    elif "-s" in word:
        file.write("\n")
    else:  
        file.write(word+" ")

file.close()
