
def card_check():
    sum = 0
    with open("/Users/quinoant/Downloads/advent-of-code/src/postgrad2023/day4/input.txt","r") as f:
        for line in f:
            card = 0
            correct,mine = line.strip().split('|')
            correct = correct.split(':')[1].strip().split()
            mine = mine.strip().split()
            for i in range(len(correct)):
                for j in range(len(mine)):
                    if(correct[i] == mine[j]):
                        if(card == 0):
                             card += 1
                        else:
                             card *= 2
            sum += card
    print(sum)

def advanced_card_check():
    sum = 0
    multiplier = [1]*220
    with open("/Users/quinoant/Downloads/advent-of-code/src/postgrad2023/day4/input.txt","r") as f:
        x = 0
        for line in f:
            mult = 0
            correct,mine = line.strip().split('|')
            correct = correct.split(':')[1].strip().split()
            mine = mine.strip().split()
            for i in range(len(correct)):
                for j in range(len(mine)):
                    if(correct[i] == mine[j]):
                        mult += 1
            for z in range(mult):
                multiplier[x+1+z] += multiplier[x]
            x += 1
            print(multiplier)
    for num in multiplier:
        sum+= num
    print(sum)
def main():
    advanced_card_check()


if __name__ == '__main__':
	main()