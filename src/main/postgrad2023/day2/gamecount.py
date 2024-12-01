#12 red cubes, 13 green cubes, and 14 blue cubes
def runner():
      sum = 0
      with open('/Users/quinoant/Downloads/advent-of-code/src/postgrad2023/day2/input.txt','r') as f:
            for line in f:
                games = line.strip().replace(",","").split(':')[1].split(';')
                works = True
                for game in games:
                    red = 12
                    green = 13
                    blue = 14
                    vals = game.strip().strip().split(" ")
                    for i in range(len(vals)):
                        if len(vals[i]) < 3:
                            continue
                        if vals[i] == 'green':
                            #   print('g')
                            green -= int(vals[i-1])
                        if vals[i] == 'blue':
                            #   print('b')
                            blue -= int(vals[i-1])
                        if vals[i] == 'red':
                            #   print('r')
                            red -= int(vals[i-1])
                    if red < 0 or green < 0 or blue < 0:
                        works = False
                    # else:
                        # print("Game: " + line.strip().split(":")[0].strip().split(" ")[1])
                        # print(red)
                        # print(green)
                        # print(blue)
                        # print()
                if works:
                    sum += int(line.strip().split(":")[0].strip().split(" ")[1])
      print(sum)

def maxfinder():
      sum = 0
      with open('/Users/quinoant/Downloads/advent-of-code/src/postgrad2023/day2/input.txt','r') as f:
            for line in f:
                games = line.strip().replace(",","").split(':')[1].split(';')
                works = True
                red_max = 0
                green_max = 0
                blue_max = 0
                for game in games:
                    red = 0
                    green = 0
                    blue = 0
                    vals = game.strip().strip().split(" ")
                    for i in range(len(vals)):
                        if len(vals[i]) < 3:
                            continue
                        if vals[i] == 'green':
                            green += int(vals[i-1])
                        if vals[i] == 'blue':
                            blue += int(vals[i-1])
                        if vals[i] == 'red':
                            red += int(vals[i-1])
                    if red > red_max:
                         red_max = red
                    if blue > blue_max:
                         blue_max = blue
                    if green > green_max:
                         green_max = green
                    # else:
                        # print("Game: " + line.strip().split(":")[0].strip().split(" ")[1])
                        # print(red)
                        # print(green)
                        # print(blue)
                        # print()
                print("red: " + str(red_max) + " blue: " + str(blue_max) + " green: " + str(green_max))
                sum += red_max*blue_max*green_max
                # if works:
                #     sum += int(line.strip().split(":")[0].strip().split(" ")[1])
      print(sum)
                        



def main():
    maxfinder()


if __name__ == '__main__':
	main()