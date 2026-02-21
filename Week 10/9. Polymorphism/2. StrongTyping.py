# Strong Typing
class Duck:
	def walk(self):
			print("Dcuk is walking")

class Horse:
	def walk(self):
		print("Horse is Running")
		
class Cat:
	def talk(self):
		print("Cat says i am hungry")
		
def myfunction(obj):
	if hasattr(obj, 'walk'):
		obj.walk()
	if hasattr(obj, 'talk'):
		obj.talk()
	
d = Duck()
myfunction(d)

h = Horse()
myfunction(h)

c = Cat()
myfunction(c)