__author__ = 'nzheng'

a = [66.25, 333, 333, 1, 1234.5]

# count(x) returns the number of time x appears in the list
print a.count(333), a.count(66.25), a.count('x')

a.insert(2, -1)  # adds -1 to index 2
a.append(333)  # adds 333 to the end
print a

print 'index of 333 is', a.index(333)  # index(x) returns the index of the FIRST found x in the list
a.remove(333)  # removes the first found 333 in the list
print 'after removing 333:', a

a.reverse()
print 'after reverse:', a

a.sort()
print 'after sort:', a

print 'pop the last item in the list', a.pop()
print 'after pop list is:', a
print 'pop index 1 in the list', a.pop(1)
print 'after pop list is:', a

# using list as stack (LIFO)
stack = [3, 4, 5]
print stack
stack.append(6)
stack.append(7)
print stack
print 'stack pop', stack.pop()

# using list as queue (FIFO - using collections.deque)
from collections import deque

queue = deque(['Eric', 'John', 'Michael'])
print queue
queue.append('Terry')
queue.append('Graham')
print queue
print queue.popleft()
print queue

# Functional Programming Tools
# filter(fcn, sequence): returns a list from sequence that satisfies fcn
def divisibleBy3Or5(x): return x % 3 == 0 or x % 5 == 0
print filter(divisibleBy3Or5, range(2, 15)) # note range(a, b) does not include b

# map(fcn, sequence): calls fcn(i) for each i in sequence and returns a list of result values
def cube(x): return x * x * x
print map(cube, range(1, 11))

# reduce(fcn, sequence): returns a single value by calling binary function fcn on (the first 2 items in the sequence),
# then on (the result and the next item)
def add(a, b): return a+b;
print reduce(add, range(1, 10))

def mySum(seq):
    def myAdd(a, b): return a+b
    return reduce(myAdd, seq, 0)  # the 3rd argument 0 indicates the starting value
print(mySum(range(1, 11)))
print(mySum([]))

# list comprehensions
squares = []
for x in range(10): squares.append(x ** 2)
print squares
# is equivalent to:
squares = map(lambda x: x ** 2, range(10))
print squares
# is equivalent to:
squares = [x ** 2 for x in range(10)]
print squares

points = [(x, y) for x in [1, 2, 3] for y in [1, 2, 3] if x != y]
print points

vec = [-4, -2, 0, 2, 4]
print [x*2 for x in vec] # do something to each element in vec
print [x+100 for x in vec if x >= 0] # filter on the elements in vec, then adds 100
freshFruit = ['   banana', ' apple', ' passion fruit   ']
print [fruit.strip() for fruit in freshFruit] # call a function on each element in freshFruit
print [(x, x**2) for x in range(6)] # create a list of 2-tuples, tuple must be parenthesized
vec = [[1, 2, 3], [4, 5, 6], [7, 8, 9]]
print [num for row in vec for num in row]  #flatten a list

from math import pi
print [str(round(pi, i)) for i in range(6)]

# Nested list comprehensions
matrix = [
    [1, 2, 3, 4],
    [5, 6, 7, 8],
    [9, 10, 11, 12]
]
print [[row[i] for row in matrix] for i in range(4)]

# remove an item at a given index
a = [-1, 1, 66.25, 333, 333, 1234.5]
del a[0]
print a
del a[2:4]  # deletes 2 and 3, excluding 4
print a
del a[:]
print a
a = [-1, 1, 66.25, 333, 333, 1234.5]
del a # now a is undefined, referencing a hereafter is an error

