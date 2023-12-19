def series_chkr(file):
    with open(file,"r") as f:
        sum = 0
        for line in f:
            line = (line.split())
            for num in range(len(line)):
                line[num] = int(line[num])
            to_chk = line.pop()
            if(next_num(line) != to_chk):
                return False
            print(str(next_num(line)) + " = " + str(to_chk))
    return True
"""
Reading in the file

"""
def series_extender(file):
    with open(file,"r") as f:
        sum = 0
        for line in f:
            line = (line.split())
            for num in range(len(line)):
                line[num] = int(line[num])
            x = next_num_rev(line)
            sum += x
        print(sum)
            
def next_num(line):
    #If everything is done start the cascade
    if all([x == 0 for x in line]):
        return 0
    next_line = []
    #Calc each value in a row besides the new col
    for i in range(len(line)-1):
        next_line.append(line[i+1]- line[i])
    y = line[len(line)-1] + next_num(next_line)
    return y

def next_num_rev(line):
    if all([x == 0 for x in line]):
        return 0
    next_line = []
    for i in range(len(line)-1):
        next_line.append(line[i+1]- line[i])
    y = line[0] - next_num_rev(next_line)
    return y


                 
def main():
    stress2 = '/Users/quinoant/Downloads/advent-of-code/src/postgrad2023/day9/stress2.txt'
    stress = '/Users/quinoant/Downloads/advent-of-code/src/postgrad2023/day9/stress.txt'
    input = '/Users/quinoant/Downloads/advent-of-code/src/postgrad2023/day9/input.txt'
    test = '/Users/quinoant/Downloads/advent-of-code/src/postgrad2023/day9/test.txt'
    series_extender(input)


if __name__ == '__main__':
	main()