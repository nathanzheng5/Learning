# use enumerate() function to get index and value when looping through a sequence
for i, v in enumerate(['tic', 'tac', 'toe']):
    print(i, v)

# use zip() to loop over 2 or more sequences
questions = ['name', 'quest', 'color']
answers = ['nathan', 'the holy grail', 'blue']
for q,a in zip(questions, answers):
    print('Your {0} is {1}'.format(q, a))

# use reversed() to loop over a sequence in reverse
for i in reversed(xrange(1, 10, 2)):
    print(i)

# use sorted() to sort a list / set
for f in sorted({'apple', 'orange', 'apple', 'pear', 'orange', 'banana'}):
    print(f)

# use iteritems() to loop through keys and values in the dictionary
for k, v in {'gallahad': 'the pure', 'robin': 'the brave'}.iteritems():
    print(k, v)

# filtering a list - instead of modifying the list, create a new list
import math
raw_data = [56.2, float('NaN'), 51.7, 55.3, 52.5, float('NaN'), 47.8]
filtered_data = []
for value in raw_data:
    if not math.isnan(value):
        filtered_data.append(value)

print(filtered_data)


