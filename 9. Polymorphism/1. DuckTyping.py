# Duck Typing
class Duck:
	def walk(self):
		print("Dcuk is walking")

class Horse:
	def walk(self):
		print("Horse is Running")
		
class Cat:
    # def talk():
    #   pass

	def walk(self):
	  print("Cat says i am hungry")
		
def myfunction(obj):
	obj.walk()
	
d = Duck()
myfunction(d)

h = Horse()
myfunction(h)

c = Cat()
myfunction(c)