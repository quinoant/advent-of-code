with open("/Users/quinoant/Downloads/advent-of-code/src/postgrad2023/day9/stress.txt") as f:
    histories = []
    for history in f.read().splitlines():
        histories.append([int(x) for x in history.split()])

total = 0
p2 = 0
for history in histories:
    descents = [history]
    while True:
        nextLevel = [descents[-1][i] - descents[-1][i-1]for i in range(1, len(descents[-1]))]
        print(nextLevel)
        if all([x == 0 for x in nextLevel]):
            break
        descents.append(nextLevel)
    print(sum([descent[-1] for descent in descents]))
    total += sum([descent[-1] for descent in descents])

    diff = 0
    for descent in reversed(descents):
        diff = descent[0] - diff
    p2 += diff

print(total)
#print(p2)