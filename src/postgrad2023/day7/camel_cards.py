input = '/Users/quinoant/Downloads/advent-of-code/src/postgrad2023/day7/input.txt'
test = '/Users/quinoant/Downloads/advent-of-code/src/postgrad2023/day7/test.txt'
stress = '/Users/quinoant/Downloads/advent-of-code/src/postgrad2023/day7/stress.txt'
'''
Every hand is exactly one type. From strongest to weakest, they are:

1) Five of a kind, where all five cards have the same label: AAAAA
2) Four of a kind, where four cards have the same label and one card has a different label: AA8AA
3) Full house, where three cards have the same label
, and the remaining two cards share a different label: 23332
4) Three of a kind, where three cards have the same label
, and the remaining two cards are each different from any other card in the hand: TTT98
5) Two pair, where two cards share one label, two other cards share a second 
, and the remaining card has a third label: 23432
6) One pair, where two cards share one label, and the other three cards have a different label from the pair and each other: A23A4
7) High card, where all cards' labels are distinct: 23456
'''
def hand_sorter(hand):
    return hand[1] + hand[2].replace('A','A').replace('K','B')\
        .replace('Q','C')\
        .replace('J','Z').replace('T','E')\
        .replace('9','F').replace('8','G')\
        .replace('7','H').replace('6','I')\
        .replace('5','J').replace('4','L')\
        .replace('3','M').replace('2','N')\
        
        

def winnings_check():
    hands = []
    with open(input, "r") as f:
        for line in f:
            hand,points = line.strip().split(" ")
            curr_hand = {}
            for letter in hand:
                if letter not in curr_hand:
                    curr_hand[letter] = 0
                curr_hand[letter] += 1
            poss_full_house = False
            poss_two_pair = False
            fail = True
            for type in curr_hand:
                if(curr_hand[type] == 5):
                    hands.append([points,'1',hand]) #5 of a kind
                    fail = False
                    break
                elif(curr_hand[type] == 4):
                    hands.append([points,'2',hand]) #4 of a kind
                    fail = False
                    break
                elif(curr_hand[type] == 3):
                    if(poss_two_pair):
                        poss_two_pair = False
                        poss_full_house = False
                        fail = False
                        hands.append([points,'3',hand])#Full house
                        break
                    poss_full_house = True
                    fail = False
                elif(curr_hand[type] == 2):
                    if(poss_full_house):
                        poss_full_house = False
                        fail = False
                        hands.append([points,'3',hand])#Full House
                        break
                    if(poss_two_pair):
                        poss_two_pair = False
                        fail = False
                        hands.append([points,'5',hand])#Two Pair
                        break
                    poss_two_pair = True
                    fail = False
            if(poss_full_house):
                fail = False
                hands.append([points,'4',hand]) #3 of a kind
            elif(poss_two_pair):
                fail = False
                hands.append([points,'6',hand])#2 of a kind
            elif(fail):
                hands.append([points,'7',hand])#High Card
        hands = sorted(hands,key=hand_sorter)
        sum = 0 
        num_hands = len(hands)
        for i in range(num_hands):
            sum += int(hands[num_hands-i-1][0]) * (i+1)
        print(sum)
                
def wildcard_check():
    hands = []
    with open(stress, "r") as f:
        for line in f:
            hand,points = line.strip().split(" ")
            curr_hand = {}
            for letter in hand:
                if letter not in curr_hand:
                    curr_hand[letter] = 0
                curr_hand[letter] += 1
            fail = True
            j_count = 0
            if('J' in curr_hand.keys()):
                j_count = curr_hand['J']
            if(len(curr_hand.keys()) == 1 or (len(curr_hand.keys()) == 2 and j_count > 0)):
                hands.append([points,'1',hand])
            elif(4 in curr_hand.values() or 
                (3 in curr_hand.values() and j_count == 1) or
                (2 in curr_hand.values() and j_count == 2)):
                hands.append([points,'2',hand]) #4 of a kind
            elif(len(curr_hand.keys()) == 2 or (len(curr_hand.keys()) == 2 and j_count>0) or
                (2 in curr_hand.values() and len(curr_hand.keys()) == 3 and j_count == 1)):
                hands.append([points,'3',hand])#Full house
            elif(3 in curr_hand.values() or (2 in curr_hand.values() and j_count == 1) or j_count ==2):
                hands.append([points,'4',hand])#3 of a kind
            elif(2 in curr_hand.values() and len(curr_hand.keys()) == 3):
                hands.append([points,'5',hand])#Two Pair
            elif(2 in curr_hand.values() or j_count == 1):
                hands.append([points,'6',hand]) # pair
            else:
                hands.append([points,'7',hand]) # high card
        hands = sorted(hands,key=hand_sorter)
        sum = 0 
        print(hands)
        num_hands = len(hands)
        for i in range(num_hands):
            sum += int(hands[num_hands-i-1][0]) * (i+1)
        print(sum)

def main():
    wildcard_check()


if __name__ == '__main__':
	main()