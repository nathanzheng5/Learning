# private variables doesn't exist in Python, but there is a convention that you can follow
# name mangling
class Mapping:

    def __init__(self, iterable):
        self.items_list = []
        self.__update(iterable)

    def update(self, iterable):
        for item in iterable:
            self.items_list.append(item)

    __update = update   # private copy of the original update() method

class MappingSubClass(Mapping):
    def update(self, keys, values):
        for item in zip(keys, values):
            self.items_list.append(item)


mapping = Mapping([1, 2, 3])
print(mapping.items_list)
mapping.update([4, 5])
print mapping.items_list

mappingSub = MappingSubClass([1, 2, 3])
print mappingSub.items_list
mappingSub.update([4, 5], ['four', 'five'])
print mappingSub.items_list
