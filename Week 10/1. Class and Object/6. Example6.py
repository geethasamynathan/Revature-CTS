# Example 6
class Mobile:
	# Constructor
	def __init__(self, m):
		self.model = m
		
	def show_model(self, p):
		price = p
		print("Model:", self.model, "and Price:", price)

realme = Mobile('RealMe X')
realme.show_model(10000)
print(id(realme))

realme1 = Mobile('RealMe X')
realme1.show_model(11000)
print(id(realme1))

redmi = Mobile('Redmi 7s')
redmi.show_model(21000)
print(id(redmi))

redmi1 = Mobile('Python')
redmi1.show_model(49)
print(id(redmi1))
