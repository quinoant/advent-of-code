def sol(binary):
    upper = 0
    lower = 0
    num = len(binary)
    for bit in range(num):
        #print(num - bit - 1)
        if binary[num - bit - 1] == 1:
            upper += pow(2,bit)
        else:
            lower += pow(2,bit)
    #print(str(lower) + "*" + str(upper))
    return lower * upper


def to_base10(binary):
    to_ret = 0
    num = len(binary)
    for bit in range(num):
        if int(binary[num - bit - 1]) == 1:
            to_ret += pow(2,bit)
    return to_ret

def oxygen_rating(file, num_bits):
    not_out0 = []
    not_out1 = []
    clean = []
    with open(file, 'r') as f:
        for line in f:
            line = line.strip()
            if int(line[0]) == 1:
                not_out1.append(line)
            else:
                not_out0.append(line)
        if(len(not_out1) >= len(not_out0)):
            clean = not_out1
        else:
            clean = not_out0
        #print(clean)
        not_out0 = []
        not_out1 = []
    for i in range(num_bits-1):
        if(len(clean) == 1):
            #print(clean)
            return clean
        for binary in clean:
            if int(binary[i+1]) == 1:
                not_out1.append(binary)
            else:
                not_out0.append(binary)
        #print("zero")
        #print(not_out0)
        #print("one")
        #print(not_out1)
        if(len(not_out1) >= len(not_out0)):
            clean = not_out1
        else:
            clean = not_out0
        not_out0 = []
        not_out1 = []
        #print("clean")
        #print(clean)
    return clean


def scubber_rating(file,num_bits):
    not_out0 = []
    not_out1 = []
    clean = []
    with open(file, 'r') as f:
        for line in f:
            line = line.strip()
            if int(line[0]) == 1:
                not_out1.append(line)
            else:
                not_out0.append(line)
        if(len(not_out0) <= len(not_out1)):
            clean = not_out0
        else:
            clean = not_out1
        #print(clean)
        not_out0 = []
        not_out1 = []
    for i in range(num_bits-1):
        if(len(clean) == 1):
            #print(clean)
            return clean
        for binary in clean:
            if int(binary[i+1]) == 1:
                not_out1.append(binary)
            else:
                not_out0.append(binary)
        #print("zero")
        #print(not_out0)
        #print("one")
        #print(not_out1)
        if(len(not_out0) <= len(not_out1)):
            clean = not_out0
        else:
            clean = not_out1
        not_out0 = []
        not_out1 = []
        #print("clean")
        #print(clean)
    return clean

def evaluator(file, num_bits):
    holder = [0]*num_bits
    to_ret = [0]*num_bits
    with open(file, 'r') as f:
        for line in f:
            line = line.strip()
            i = 0
            for bit in line:
                holder[i] += int(bit)
                i+= 1
    print(holder)
    for bit in range(num_bits):
        if holder[bit] > 500:
            to_ret[bit] = 1
    return to_ret




def main():
    file = 'input.txt'
    len = 12
    print("part 1: " + str(sol(evaluator(file,len))))
    ox = to_base10(oxygen_rating(file,len)[0])
    co2 = to_base10(scubber_rating(file,len)[0])
    print("part 2: " + str(ox*co2))
    #print("ready")


if __name__ == '__main__':
	main()