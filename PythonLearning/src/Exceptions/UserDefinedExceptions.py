class MyError(Exception):

    def __init__(self, value):
        self.value = value

    def __str__(self):
        return repr(self.value)


try:
    raise MyError('oh my error message')
except MyError as e:
    print 'My error was caught: value=', e.value