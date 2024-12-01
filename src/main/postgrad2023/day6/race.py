test = '/Users/quinoant/Downloads/advent-of-code/src/postgrad2023/6/test2.txt'
input = '/Users/quinoant/Downloads/advent-of-code/src/postgrad2023/day6/input2.txt'
def winner():
    t_d = []
    sum = 1
    with open(input,"r") as f:
        for line in f:
            t_d.append(line.strip().split(':')[1].strip().split())
        for race in range(len(t_d[0])):
            poss_wins = 0
            for i in range(int(t_d[0][race])):
                if(i*(int(t_d[0][race])-i) > int(t_d[1][race])):
                    #print(i*(int(t_d[0][race])-i))
                    poss_wins+=1
            if(poss_wins > 0):
                sum *= poss_wins
    print(sum)

def winner_sidecheck():
    t_d = []
    with open(input,"r") as f:
        for line in f:
            t_d.append(line.strip().split(':')[1].strip().split())
        for race in range(len(t_d[0])):
            #print(race)
            poss_wins = 0
            for i in range(int(t_d[0][race])):
                if(i*(int(t_d[0][race])-i) > int(t_d[1][race])):
                    #print(i*(int(t_d[0][race])-i))
                    poss_wins+=1
                    print("winner: " + str(int(t_d[0][race])-(i*2)+1))
                    return
            if(poss_wins > 0):
                sum *= poss_wins
                
            


def main():
    winner_sidecheck()


if __name__ == '__main__':
	main()