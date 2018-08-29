def fib(n):
    a, b = 0, 1
    while a < n:
        print a,            # comma avoids going to the next line
        a, b = b, a + b

fib(2000)

print '\n'
print fib
f = fib
f(100)

# fib() doesn't explicitly return anything, so it just returns None
print '\n'
print fib(0)

def fibList(n):
    result = []
    a, b = 0, 1
    while a < n:
        result.append(a)
        a, b = b, a+b
    return result

print fibList(100)
