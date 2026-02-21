# Writing Data with x mode
f = open('student.txt', mode='x')
f.write('Hello\n')
f.write('sample code\n')
f.write('How are you')
f.close()
print('Success')

