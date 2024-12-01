import re
def adjacency():
    vals = []
    sum = 0
    with open('/Users/quinoant/Downloads/advent-of-code/src/postgrad2023/day3/input.txt','r') as f:
        for line in f:
            vals.append(line.strip())
        for i in range(len(vals)):
            search = re.finditer("\d+",vals[i])
            for match in search:
                s = match.start()
                e = match.end()
                # print('String match "%s" at %d:%d' % (vals[i][s:e], s, e))
                #look left
                if(s > 0): #s is not on the left wall
                    if(vals[i][s-1:s] != '.'):
                        sum += int(vals[i][s:e])
                        #print('1')
                        continue #real
                #look right
                if(e < len(line)): #s is not on the right wall
                    if(vals[i][e:e+1] != '.'):
                        sum += int(vals[i][s:e])
                        #print('2')
                        continue #real
                #look up
                if(i > 0):
                    if(re.search("[^.]",vals[i-1][s-1:e+1]) is not None):
                        sum += int(vals[i][s:e])
                        continue #real
                    if(re.search("[^.]",vals[i-1][s-1:e]) is not None):
                        sum += int(vals[i][s:e])
                        #print('4')
                        continue #real
                    if(re.search("[^.]",vals[i-1][s:e+1]) is not None):
                        sum += int(vals[i][s:e])
                        #print('5')
                        continue #real
                #look down
                if(i < 139):
                    #print(vals[i+1][s-1:e+1])
                    if(re.search("[^.]",vals[i+1][s-1:e+1]) is not None):
                        #print('6')
                        sum += int(vals[i][s:e])
                        continue #real
                    if(re.search("[^.]",vals[i+1][s-1:e]) is not None):
                        sum += int(vals[i][s:e])
                        #print('7')
                        continue #real
                    if(re.search("[^.]",vals[i+1][s:e+1]) is not None):
                        sum += int(vals[i][s:e])
                        #print('8')
                        continue #real
                    #print('xxxxxxx "%s" at %d:%d' % (vals[1][s-1:e+1], s-1, e+1))
                #print('String match "%s" at %d:%d on line %d' % (vals[i][s:e], s, e,i+1))
    # print(vals[0])
    # print(vals[1])
    # print(vals[2])
    print(sum)     
    #print(vals[1])            
        #look to the sides
        #look above
        #look below


def main():
    adjacency()


if __name__ == '__main__':
	main()