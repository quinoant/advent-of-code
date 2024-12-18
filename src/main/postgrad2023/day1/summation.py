import re

def runner():
    sum = 0
    with open('/Users/quinoant/Downloads/advent-of-code/src/postgrad2023/day1/input.txt', 'r') as f:
         for line in f:
              line = line.replace("one","one1one")\
                .replace("two","two2two")\
                .replace("three","three3three")\
                .replace("four","four4four")\
                .replace("five","five5five")\
                .replace("six","six6six")\
                .replace("seven","seven7seven")\
                .replace("eight","eight8eight")\
                .replace("nine","nine9nine")
              res = [int(i) for i in line if i.isdigit()]
              sum += (int(str(res[0]) + str(res[len(res)-1])))
    print(sum)


def main():
    runner()


if __name__ == '__main__':
	main()