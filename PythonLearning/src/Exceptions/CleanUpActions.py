def divide(x, y):
    try:
        result = x / y
    except ZeroDivisionError:
        print 'division by zero!'
    else:
        print 'result is', result
    finally:
        print 'I\'m printed anyway'

# divide(2, 1)
# divide(2, 0)
#divide('2', '1') # finally will be executed, but TypeError is not caught, so it's thrown


# some objects has standard clean up actions - to be run when the object is no longer needed, regardless of whether the operation has succeeded or failed
# use 'with' statement to allow objects like files to be used in a way ensuring they are always cleaned up promptly and correctly
with open('myfile.txt') as f:
    for line in f:
        print line
# file 'f' is always closed even if exception occurs

