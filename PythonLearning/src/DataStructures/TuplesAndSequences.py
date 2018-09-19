t = 12345, 54321, 'hello'
print(t[0])
print(t)

# tuples can be nested
u = t, (1, 2, 3, 4, 5)
print(u)
print(u[0])
print(u[1])
print(u[0][0])

# tuples are immutable, the follwoing is an error
# t[0] = 88888
# but tuples can contain mutable objects
v = ([1, 2, 3], [4, 5, 6])
# v[0] = [1] ERROR: tuples are immutable
v[0][0] = 0 # OK, tuple elements don't have to be immutable
print(v)
# tuples are immutable, usually contain a heterogeneous sequence of elements that are accessed via unpacking
# lists are mutable, usually contain homogeneous sequence of elements that are accessed by iterating over the list

