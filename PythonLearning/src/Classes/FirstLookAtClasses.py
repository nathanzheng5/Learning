class MyClass:
    """ doc for My class """
    i = 12345

    def __init__(self):
        self.data = 1

    def f(self):
        return 'hello my class'

print(MyClass.i)
print(MyClass.f)

MyClass.i = 54321
print(MyClass.i)
# the following is wrong: f() must be called on an instance of MyClass
#print(MyClass.f())

print(MyClass.__doc__)  #__doc__ is a valid built in attribute, returning the docstring of MyClass

# instantiate an object
x = MyClass()
print(x.f())    # now the function can be called on the instance - referencing function attribute
print(x.data)   # referencing data attribute
print(x.i)

class Complex:
    def __init__(self, real, imaginary):
        self.real = real
        self.imaginary = imaginary

    def f(self, i=0):
        return self.real + i, self.imaginary

x = Complex(2, 5)
print(x.real, x.imaginary)

x.counter = 1
print x.counter
while x.counter < 10:
    x.counter *= 2
print x.counter
del x.counter

# the following is wrong - real belongs to the instance, not the Class
# print Complex.real

# store the method object and use it later
XF = x.f
print(XF)
print(XF())
print(XF(1))

class Dog:
    kind = 'canine'             # class variable shared by all instances

    # tricks = []                 # this is bad - it's shared by all class instances

    def __init__(self, name):
        self.name = name        # instance variable unique to each instance

        self.tricks = []

    def addTrick(self, trick):
        self.tricks.append(trick)

    def addTricks(self, tricks):
        for trick in tricks:
            self.addTrick(trick)

d = Dog('Dolce')
e = Dog('Estee')

print(d.kind)
print(e.kind)
print(d.name)
print(e.name)
print(Dog.kind)     # valid - kind is class variable
#print(Dog.name)     # invalid - name is instance variable

d.addTrick('roll')
e.addTrick('barf')

print(d.tricks)
print(e.tricks)

d.addTricks(['play', 'shoot'])
print(d.tricks)
