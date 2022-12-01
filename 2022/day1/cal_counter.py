def runner0():
    with open('input.txt', 'r') as f:
        curr = 0
        curr_elf = 1
        max = 0
        top = 0
        for line in f:
            if line.strip():
                curr = curr + int(line)
                #print(curr)
            else:
                if top < curr:
                    top = curr
                elf = curr_elf
                curr = 0
                curr_elf = curr_elf + 1
        if top < curr:
            top = curr
        print("part 1: " + str(top))
def runner1():
    top = 0
    second = 0
    third = 0
    elf = 1
    with open('input.txt', 'r') as f:
        curr = 0
        curr_elf = 1
        max = 0
        for line in f:
            if line.strip():
                curr = curr + int(line)
                #print(curr)
            else:
                if top < curr:
                    third = second
                    second = top
                    top = curr
                elif second < curr:
                    third = second
                    second = curr
                elif third < curr:
                    third = curr
                elf = curr_elf
                curr = 0
                curr_elf = curr_elf + 1
        if top < curr:
            third = second
            second = top
            top = curr
        elif second < curr:
            third = second
            second = curr
        elif third < curr:
                third = curr
        max = top + second + third
        print("part 2: " + str(max))



def main():
    runner0()
    runner1()


if __name__ == '__main__':
	main()