#pop() method

a = [10, 20, 30, 10, 90, 'Python Demos']

print("Before POP:", a)

removedElement=a.pop()
print('removedElement',removedElement)
print("After POP:", a)

for element in a:
	print(element)

