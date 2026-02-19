#extend() Method
a = [10, 20, 30, 10, 90, 'Python Demos']
b = [100, 200, 300]

print("Before Extend:",a)

a.extend(b)

print("After Extend:",a)

for element in a:
	print(element)

