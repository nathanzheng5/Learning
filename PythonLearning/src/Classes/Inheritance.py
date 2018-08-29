class Animal:

    def __init__(self, name):
        self.name = name

    def say(self):
        print('Animal Sound')

animal = Animal('General animal')
print(animal.name)
animal.say()

class Dog(Animal):
    def say(self):
        Animal.say(self)    # calling super class method
        print('Woof')

dog = Dog('My Dog')
print(dog.name)
dog.say()

print(isinstance(dog, Dog))
print(isinstance(dog, Animal))
print(isinstance(animal, Dog))

class GoodDog(Dog):
    def say(self):
        print('I\'m a good dog')

goodDog = GoodDog('My good dog')
print(isinstance(goodDog, Animal))
print(issubclass(Dog, Animal))
print 'issubclass(GoodDog, Animal)', issubclass(GoodDog, Animal)

# multiple inheritance
class Base1Base:
    def say(self):
        print('base 1 base')

class Base1(Base1Base):
    placeholder = ''

class Base2:
    def say(self):
        print('base 2')

class Base3:
    def say(self):
        print('base 3')

class DerivedClass(Base1, Base2, Base3):
    pass

    # do nothing

derivedInstance = DerivedClass()
derivedInstance.say()
# depth-first, left-to-right
# first search within DerivedClass, then Base1, and Base1's super class, then Base 2, etc...

