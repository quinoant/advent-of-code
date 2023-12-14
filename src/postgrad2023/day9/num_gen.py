def series_extender(file):
    with open(file,"r") as f:
        sum = 0
        for line in f:
            line = (line.split())
            for num in range(len(line)):
                line[num] = int(line[num])
            x = next_num_rev(line)
            #print(x)
            sum += x
        print(sum)

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
            
def next_num(line):
    #print(line)
    if all([x == 0 for x in line]):
        return 0
    next_line = []
    for i in range(len(line)-1):
        next_line.append(line[i+1]- line[i])
    return line[len(line)-1] + next_num(next_line)

def next_num_rev(line):
    if all([x == 0 for x in line]):
        return 0
    next_line = []
    for i in range(len(line)-1):
        next_line.append(line[i+1]- line[i])
    x = line[0] - next_num_rev(next_line)
    return x


                 
def main():
    stress2 = '/Users/quinoant/Downloads/advent-of-code/src/postgrad2023/day9/stress2.txt'
    stress = '/Users/quinoant/Downloads/advent-of-code/src/postgrad2023/day9/stress.txt'
    input = '/Users/quinoant/Downloads/advent-of-code/src/postgrad2023/day9/input.txt'
    test = '/Users/quinoant/Downloads/advent-of-code/src/postgrad2023/day9/test.txt'
    series_extender(input)


if __name__ == '__main__':
	main()