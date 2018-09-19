basket = ['apple', 'orange', 'apple', 'pear', 'orange', 'banana']
fruit = set(basket) # creates a set without duplicates
print(fruit)

print('orange' in fruit)  # whether 'orange' is in the set
print('hello' in fruit)

a = set('abracadabra')
b = set('alacazam')
print('a', a)
print('b', b)

# letter in a but not in b
print('letters in a but not in b', a - b)
print('letters in either a or b', a | b)
print('letters in both a and b', a & b)
print('letter in a or b, but not both', a ^ b)

# set comprehension
a = {x for x in 'abracadabra' if x not in 'abc'}
print(a)
b = {x for x in 'apple'}
print(b)

