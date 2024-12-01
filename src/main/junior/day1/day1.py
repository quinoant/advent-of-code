
def inc_chkr2():
    holder = [0,0,0,0]
    inc = 0
    tot = 0
    with open('input.txt', 'r') as f:
        curr = 0
        for line in f:
            #print(str(holder[1]+holder[2]+holder[3])+ "<"+str(holder[0]+holder[1]+holder[2]))
            if(holder[3] != 0 and (holder[1]+holder[2]+holder[3]) < holder[0]+holder[1]+holder[2]):
                #print(str(holder[0])+ "\n" +str(holder[1])+ "\n" +str(holder[2])+ "\n" +str(holder[3]))
                inc += 1
            holder[3] = holder[2]
            holder[2] = holder[1]
            holder[1] = holder[0]
            holder[0] = int(line)
            #print(holder)
            curr = 1
        #print(str(holder[1]+holder[2]+holder[3])+ "<"+str(holder[0]+holder[1]+holder[2]))
        if(holder[3] != 0 and (holder[1]+holder[2]+holder[3]) < holder[0]+holder[1]+holder[2]):
                #print(str(holder[0])+ "\n" +str(holder[1])+ "\n" +str(holder[2])+ "\n" +str(holder[3]))
                inc += 1

    print("part 2: " + str(inc))

def inc_chkr1():
    inc = 0
    with open('input.txt', 'r') as f:
        curr = 0
        for line in f:
            if(curr != 0 and curr < int(line)):
                inc += 1
            curr = int(line)
            
    print("part 1: " + str(inc))


def main():
    inc_chkr1()
    inc_chkr2()


if __name__ == '__main__':
	main()