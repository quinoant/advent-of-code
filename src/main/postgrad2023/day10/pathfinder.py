def pathfinder(file):
    tunnels = []
    start = [-1]*2
    with open(file, "r") as f:
        for line in f:
            tunnels.append(line.strip())
            while(start[0] == -1):
                for letter in range(len(line)):
                    print(str(letter) + " x:" + str(len(line)) + " y:" + str(letter))
                    if line[letter] == 'S':
                        start[0] = len(line)-1
                        start[1] = letter
                




def main():
    test2 = '/Users/quinoant/Downloads/advent-of-code/src/postgrad2023/day10/test.txt'
    input = '/Users/quinoant/Downloads/advent-of-code/src/postgrad2023/day10/input.txt'
    test = '/Users/quinoant/Downloads/advent-of-code/src/postgrad2023/day10/test.txt'
    pathfinder(test)


if __name__ == '__main__':
	main()