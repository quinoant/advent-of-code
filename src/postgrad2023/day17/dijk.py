def map_maker(file):
    map = []
    with open(file,"r") as f:
        for line in f:
            curr = []
            for item in line.strip():
                curr.append(int(item))
            map.append(curr)
            print(map)
    for i in range(len(map)):
        for j in range(len(map[0])):
            try:
                #top
                #bottom
                #left
                #right
            finally:
                print()

def main():
    test2 = '/Users/quinoant/Downloads/advent-of-code/src/postgrad2023/day17/test2.txt'
    input = '/Users/quinoant/Downloads/advent-of-code/src/postgrad2023/day17/input.txt'
    test = '/Users/quinoant/Downloads/advent-of-code/src/postgrad2023/day17/test.txt'
    map_maker(test)


if __name__ == '__main__':
	main()