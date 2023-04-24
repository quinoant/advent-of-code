
def sack_organizer(file):
    with open(file, 'r') as f:
        collection = []
        for line in f:
            line = line.strip()
            mid = int(len(line)/2)
            front = line[:mid]
            back = line[mid:]
            found = 1
            for i in front:
                for j in back:
                    if(i == j):
                        collection.append(i)
                        found = 0
                        break
                if(found == 0):
                    found = 1
                    break
    #print(collection)
    return collection

def search(to_search):
    for i in to_search[0]:
        for j in to_search[1]:
            if(i == j):
                for x in to_search[2]:
                    if(x == i):
                        #print(i)
                        return i
    #print("x")

def badge_maker(file):
    collection = []
    curr = [0]*3
    curr_index = 0
    with open(file, 'r') as f:
        for line in f:
            line = line.strip()
            if(curr_index >= 3):
                #print(curr)
                collection.append(search(curr))
                curr = [0]*3
                curr_index = 0
            curr[curr_index] = line
            curr_index += 1
        collection.append(search(curr))
    return collection



def tally(collection):
    tally = 0
    for item in collection:
        val = ord(item)
        if val >= 97:
            tally += val - 96
        else:
            tally += val - 38
    return tally


def main():
    file = 'input.txt'
    print("part 1: " + str(tally(sack_organizer(file))))
    print("part 2: " + str(tally(badge_maker(file))))
    len = 12

if __name__ == '__main__':
	main()