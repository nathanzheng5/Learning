# default arguments =======================================================================
def ask_ok(prompt, retries=4, complaint='Yes or no, please?'):
    while True:
        ok = raw_input(prompt)
        if ok in ('y', 'ye', 'yes'):
            return True
        if ok in ('n', 'no'):
            return False
        retries -= 1
        if retries < 0:
            raise IOError('refusenik user')
        print complaint, 'num tries left', retries

# ask_ok('do something?')
# ask_ok('do something?', 1)
# ask_ok('do something?', 2, 'what the fuck, do again')

# default values are evaluated at the point of function definition in the defining scope
i = 5
def f(arg = i) :
    print arg
i = 6
f()

# default value is evaluated ONLY ONCE - if the default is a mutable object (list, dict, ...), it's not going back to the default again
def f2(a, L=[]):
    L.append(a)
    return L

print f2(1) # L would be [] when the function started
print f2(2) # L would be [1] when the function started
print f2(3) # L would be [1, 2] when the function started

# if you don't want the default to be shared with subsequent calls
def f3(a, L=None):
    if L is None:
        L = []
    L.append(a)
    return L

print f3(1)
print f3(2)
print f3(3)

# keyword arguments =======================================================================
def parrot(voltage, state='a stiff', action='voom', type='Norwegian Blue'):
    print "-- This parrot wouldn't", action,
    print "if you put", voltage, "volts through it."
    print "-- Lovely plumage, the", type
    print "-- It's", state, "!"

# parrot(1000)                                      # 1 positional arg
# parrot(voltage=1000)                              # 1 keyword arg
# parrot(1000, action='VOOOOOOOOOOOM')              # 1 positional arg, 1 keyword arg
# parrot(action='VOOOOOOOOOOOM', voltage=1000)      # 2 keyword args
# parrot('a thousand', 'my state', 'my action')      # 3 keyword args

# all of the following would be wrong
# parrot()                     # required argument missing
# parrot(voltage=5.0, 'dead')  # non-keyword argument after a keyword argument
# parrot(110, voltage=220)     # duplicate value for the same argument
# parrot(actor='John Cleese')  # unknown keyword argument

# if an arg is in the form of *tuple, it receives a tuple containing positional args beyond the formal arg list
# if an arg is in the form of *map, it receives a dictionary containing all keyword args beyond the formal arg list
def cheeseshop(kind, *arguments, **keywords):
    print "-- Do you have any", kind, "?"
    print "-- I'm sorry, we're all out of", kind
    for arg in arguments:
        print arg
    print "-" * 40
    keys = sorted(keywords.keys())
    for kw in keys:
        print kw, ":", keywords[kw]
cheeseshop("Limburger",
           "It's very runny, sir.",
           "It's really very, VERY runny, sir.",
           'argument 3',
           shopkeeper='Michael Palin',
           client="John Cleese",
           sketch="Cheese Shop Sketch",
           myKey='My Value')

def cheeseshop2(kind, *tupleArgs):
    for arg in tupleArgs:
        print arg
    print(kind)

cheeseshop2('Kind', 'arg1', 'arg2', 'arg3')

def cheeseshop3(kind, **dictArgs):
    for key in dictArgs.keys():
        print key, ":", sorted(dictArgs[key])
    print kind
cheeseshop3("kind", key1='value 1', key2='value 2')

# arbitrary argument lists =======================================================================
def arbitraryArgList(separator, *args):
    print separator.join(args)
arbitraryArgList("-", 'hello', 'world', 'java')

# unpacking argument lists - arguments are already in a list, but function expects args separately
args = [3,10,2]
print range(*args)  # range() expects start, stop, step arguments

def parrot2(voltage, state='a stiff', action='voom'):
    print "-- This parrot wouldn't", action,
    print "if you put", voltage, "volts through it.",
    print "E's", state, "!"
mapArg = {'voltage' : 1000, 'state': 'dead', 'action' : 'blah!!!'}
parrot2(**mapArg)

# Lambda Expressions =======================================================================
def make_incrementor(n):
    return lambda x, b =1: (x + n) * b

f = make_incrementor(50)
print f(1, 2)
print f(5, 3)

pairs = [(1, 'one', 4), (2, 'two', 3), (3, 'three', 2), (4, 'four', 1)]
pairs.sort(key=lambda pair : pair[1])   # sort by the element 1 in the tuple. i.e. english word
print pairs
pairs.sort(key=lambda pair : pair[2])
print pairs
pairs.sort(key=lambda pair : pair[0])
print pairs
