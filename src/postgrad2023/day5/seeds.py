import numpy as np

input = '/Users/quinoant/Downloads/advent-of-code/src/postgrad2023/day5/input.txt'
test = '/Users/quinoant/Downloads/advent-of-code/src/postgrad2023/day5/test.txt'

def initial_seeds():
    with open(input,"r") as f:
        seeds = []
        
        for seed in f.readline().split(':')[1].strip().split():
            seeds.append(int(seed))
        for i in range(8):
            seed_finder(f,seeds)
            print()
        victor = 10000000000000000
        for winner in seeds:
            if(winner < victor):
                victor = winner
                print(winner)
        print(victor)

def initial_seeds_2():
    with open(input,"r") as f:
        seeds = []
        runner = 0
        last_seed = 0
        for seed in f.readline().split(':')[1].strip().split():
            if(runner) < 4:
                #print('x')
                runner +=1
                continue
            elif(runner > 5):
                #print('y')
                break
            if(runner%2==1):
                for x in range(int(seed)):
                    seeds.append(last_seed+x)
            else:
                last_seed = int(seed)
            runner +=1
        for i in range(8):
            seed_finder(f,seeds)
            print()
        victor = 10000000000000000
        for winner in seeds:
            if(winner < victor):
                victor = winner
                #print(winner)
        print(victor) #702443113,800883183
            
        
        

def seed_finder(file,seeds):
    seed_map = []
    line = file.readline().strip()
    while(line != ''):
        vals = line.strip().split()
        if(len(vals) == 3):
            seed_map.append([int(vals[1]),int(vals[1])+int(vals[2])-1,int(vals[0])-int(vals[1])])
            # seed_map.append([int(vals[0]),int(vals[1]),int(vals[2])])
        
        line = file.readline().strip() # end
    for seed_loc in range(len(seeds)):
        for mapping in seed_map:
            if(seeds[seed_loc] >= mapping[0] and seeds[seed_loc] <= mapping[1]):
                seeds[seed_loc] += mapping[2]
                break
    #print(seed_map)
    #print(seeds)
    return


def main():
    initial_seeds()


if __name__ == '__main__':
	main()