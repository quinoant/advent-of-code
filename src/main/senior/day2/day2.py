
def win_chkr1(elf,strat):
    strat = strat.strip()
    loss = 0
    tie = 3
    win = 6
    if(elf == 'A'):
        if strat == 'X':
            #print('A and X: ' + str(1 + tie))
            return 1 + tie
        elif strat == 'Y':
            #print('A and Y: ' + str(2 + win))
            return 2 + win
        else:
            #print('A and Z: ' + str(3 + loss))
            return 3 + loss
    elif(elf == 'B'):
        if strat == 'X':
            #print('B and X: ' + str(1 + loss))
            return 1 + loss
        elif strat == 'Y':
            #print('B and Y: ' + str(2 + tie))
            return 2 + tie
        else:
            #print('B and Z: ' + str(3 + win))
            return 3 + win
    else:
        if strat == 'X':
            #print('C and X: ' + str(1 + win))
            return 1 + win
        elif strat == 'Y':
            #print('C and Y: ' + str(2 + loss))
            return 2 + loss
        else:
            #print('C and Z: ' + str(3 + tie))
            return 3 + tie

def win_chkr2(elf,strat):
    strat = strat.strip()
    loss = 0
    tie = 3
    win = 6
    if(elf == 'A'):
        if strat == 'X':
            return 3 + loss
        elif strat == 'Y':
            return 1 + tie
        else:
            return 2 + win
    elif(elf == 'B'):
        if strat == 'X':
            return 1 + loss
        elif strat == 'Y':
            return 2 + tie
        else:
            return 3 + win
    else:
        if strat == 'X':
            return 2 + loss
        elif strat == 'Y':
            return 3 + tie
        else:
            return 1 + win

def point_calc():
    total_score1 = 0
    total_score2 = 0
    with open('input.txt', 'r') as f:
        for line in f:
            input = line.split(" ")
            total_score1 += win_chkr1(input[0],input[1])
            total_score2 += win_chkr2(input[0],input[1])
        print("part 1 : " + str(total_score1))
        print("part 2 : " + str(total_score2))
            

def main():
    point_calc()
    #print("ready!")


if __name__ == '__main__':
	main()