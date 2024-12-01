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
input: file to read
output: nada prints answer
Method: 
Feeds each line into next_num machine as ints for easier processing
adds that answer to the sum
prints out the answer
"""
def series_extender(file):
    with open(file,"r") as f:
        sum = 0
        for line in f:
            line = (line.split())
            for num in range(len(line)):
                line[num] = int(line[num])
            x = next_num(line)
            print()
            sum += x
        print(sum)

"""
input: a list of ints to read
output: the next num in the series
method: 
1. do a kind of derivitive by subtracting the next number in a series by
the previous to make a new list (steps 1 - 4)
2.when you have all 0s in a derived row return 0(step 5)
3.add the last number that you derived to the next number in the
derivation of the current series and return it (steps 6-9)

ie 
(step 0)10  13  16  21  30  45  (step 9)(45+23)
(step 1)   3   3   5   9  15   (step 8)(15+8)
(step 2)      0   2   4   6  (step 7)(6+2)
(step 3)        2   2   2  (step 6)(2+0)
(step 4)           0   0 (step 5)(0+0)
"""
def next_num(line):
    #If everything is done start the cascade
    if all([x == 0 for x in line]):
        return 0
    next_line = []
    #Calc each value in current row besides the new col
    for i in range(len(line)-1):
        next_line.append(line[i+1]- line[i])
    # calculate new col
    y = line[-1] + next_num(next_line)
    print(y)
    return y

"""
input: a list of ints to read
output: the next num in the series
method: 
1. do a kind of derivitive by subtracting the next number in a series by
the previous to make a new list (steps 1 - 4)
2.when you have all 0s in a derived row return 0(step 5)
3.subtract the last number that you derived from the first number in the
derivation of the current series and return it (steps 6-9)

ie 
(step 9) (10-5)  (step 0)10  13  16  21  30  45
(step 8) (3-(-2))(step 1)   3   3   5   9  15   
(step 7) (0-2)   (step 2)     0   2   4   6 
(step 6) (2-0)   (step 3)       2   2   2 
(step 5) 0       (step 4)         0   0
"""
def next_num_rev(line):
    #If everything is done start the cascade
    if all([x == 0 for x in line]):
        return 0
    next_line = []
    #Calc each value in current row besides the new col
    for i in range(len(line)-1):
        next_line.append(line[i+1]- line[i])
    # calculate new col
    y = line[0] - next_num_rev(next_line)
    print(y)
    return y


                 
def main():
    stress2 = '/Users/quinoant/Downloads/advent-of-code/src/postgrad2023/day9/stress2.txt'
    stress = '/Users/quinoant/Downloads/advent-of-code/src/postgrad2023/day9/stress.txt'
    input = '/Users/quinoant/Downloads/advent-of-code/src/postgrad2023/day9/input.txt'
    test = '/Users/quinoant/Downloads/advent-of-code/src/postgrad2023/day9/test.txt'
    series_extender(input)


if __name__ == '__main__':
	main()