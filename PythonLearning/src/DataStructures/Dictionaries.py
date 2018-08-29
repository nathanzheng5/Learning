# dictionary keys should be immutable (e.g. strings, numbers, tuples with strings / numbers)
tel = {'jack': 4098, 'sape': 4139}
print tel['jack']
tel['guido'] = 4127
print tel
del tel['jack']
print tel

print tel.keys()
print 'guido' in tel
print 'jack' in tel

# use the dict() constructor with sequence of key-value pairs
print dict([('sape', 4139), ('guido', 4127), ('jack', 4098)])

# dict comprehension
print {x: x ** 2 for x in (2, 4, 6)}

# when keys are simple strings, don't need the quote sign
print dict(sape=4139, guido=4127, jack=4098)

myDict = dict(tools = ['javac', 'jar', 'mingw']).keys()
myDict.append(name='nathan')
