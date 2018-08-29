# gives in a ZeroDivisionError
#10 * (1/0)

# gives NameError
# 4 + spam*3

# gives TypeError
#'2' + 2

# handle exceptions
"""
try:
    x = int(raw_input('Please enter a number'))
    print x, ' is a good number'

except (ValueError, TypeError, ''', OtherException'''):
    print 'that was not a valid number'
"""

"""
import sys
try:
    f = open('myfile.txt')
    s = f.readline()
    i = int(s.strip())
except IOError as e:
    print 'IOError({0}: {1})'.format(e.errno, e.strerror)
except ValueError:
    print 'Could not convert data to an integer'
except:
    print 'Unexpected Error:', sys.exc_info()[0]
    raise # whatever the unexpected exception is
else:
    # better put here than in the try clause - avoids accidental catching of an exception that wasn't raised by the code being protected by the try
    print 'i =', i
"""

try:
    raise Exception('spam', 'eggs')
except Exception as inst:
    print type(inst)
    print inst.args
    print inst      # __str__ allows args to be printed directly
    x, y = inst.args
    print 'x=', x
    print 'y=', y

def this_fails():
    x = 1/0

try:
    this_fails()
except ZeroDivisionError as detail:
    print 'handling:', detail

