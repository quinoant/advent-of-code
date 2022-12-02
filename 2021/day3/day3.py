def evaluator():
    with open('test.txt', 'r') as f:
        curr = 0
        holder = [0]*50
        print(holder)
        for line in f:
            line.strip()
            i = 0
            for bit in line:
                holder[i] += int(bit)
                i+= 1
        print(holder)



def main():
    evaluator()
    print("ready")


if __name__ == '__main__':
	main()