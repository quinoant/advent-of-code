def maze_runner(file):
    intersections = {}
    with open(file,"r") as f:
        directions = f.readline().strip()
        f.readline()
        curr = 'AAA'
        for line in f.readlines():
            spot, turns = line.split("=")
            intersections[spot.strip()] = turns.replace('(','')\
            .replace(')','').replace(' ','').strip().split(',')
        loc = 0
        while(curr != 'ZZZ'):
            #print(intersections[curr])
            curr_intersection = intersections[curr]
            if(directions[loc%(len(directions))] == 'R'):
                curr = curr_intersection[1]
            else:
                curr = curr_intersection[0]
            loc += 1
        print(loc)
        
        
def ghost_runner(file):
    intersections = {}
    with open(file,"r") as f:
        directions = f.readline().strip()
        f.readline()
        curr = []
        for line in f.readlines():
            spot, turns = line.split("=")
            intersections[spot.strip()] = turns.replace('(','')\
            .replace(')','').replace(' ','').strip().split(',')
            if(spot.strip()[2] == 'A'):
                curr.append(spot.strip())
        loc = 0
        searching = True
        wins = 0
        # print(len(curr))
        # print(curr)
        while(check(curr)):
            wins = 0
            #print(intersections[curr])
            for line in range(len(curr)):
                curr_intersection = intersections[curr[line]]
                #print(curr_intersection)
                if(directions[loc%(len(directions))] == 'R'):
                    curr[line] = curr_intersection[1]
                else:
                    curr[line] = curr_intersection[0]
            loc += 1
            print(curr)
        print(loc)

def check(curr):
    for loc in curr:
        if loc[2] != 'Z':
            return True
    return False

def ghostbusters(file):
    intersections = {}
    with open(file,"r") as f:
        directions = f.readline().strip()
        f.readline()
        curr = []
        for line in f.readlines():
            spot, turns = line.split("=")
            intersections[spot.strip()] = turns.replace('(','')\
            .replace(')','').replace(' ','').strip().split(',')
            if(spot.strip()[2] == 'A'):
                curr.append(spot.strip())
    #for ghost in curr:
    loc_list = []
    ghost = curr[1]
    loc = 0
    while(loc < 200):
        #print(intersections[curr])
        curr_intersection = intersections[ghost]
        if(directions[loc%(len(directions))] == 'R'):
            ghost = curr_intersection[1]
        else:
            ghost = curr_intersection[0]
        if(ghost[2] == 'Z'):
            #print(loc)
            loc_list.append(loc)
        loc += 1
    for i in range(len(loc_list)-1):
        print(loc_list[i+1]-loc_list[i])#20659,20093,14999,17263,22357,16697
def crazy():
    periods = [20659,20093,14999,17263,22357,16697]
    mult = 1
    while(True):
        for i in range(len(periods-1)):
            if(periods[i]*mult != periods[i+1]*mult):
                break

        mult += 1
def main():
    stress2 = '/Users/quinoant/Downloads/advent-of-code/src/postgrad2023/day8/stress2.txt'
    stress = '/Users/quinoant/Downloads/advent-of-code/src/postgrad2023/day8/stress.txt'
    input = '/Users/quinoant/Downloads/advent-of-code/src/postgrad2023/day8/input.txt'
    test = '/Users/quinoant/Downloads/advent-of-code/src/postgrad2023/day8/test.txt'
    #maze_runner(input)
    #ghost_runner(stress2)
    ghostbusters(stress2)


if __name__ == '__main__':
	main()