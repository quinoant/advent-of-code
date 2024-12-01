
from functools import reduce

def find_number_by_divisors(divisors):
    # Find the least common multiple (LCM) of the divisors
    lcm = reduce(lambda x, y: x * y // gcd(x, y), divisors)
    
    return lcm

def gcd(a, b):
    while b:
        a, b = b, a % b
    return a

# Example divisors
divisors = [20659, 20093, 14999, 17263, 22357, 16697]

# Find the number by its divisors
result = find_number_by_divisors(divisors)

print(f"The number with divisors {divisors} is: {result}")