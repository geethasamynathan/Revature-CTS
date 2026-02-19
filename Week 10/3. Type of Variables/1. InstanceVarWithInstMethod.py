# Instance Variable with Instance Method
class Mobile:
	def __init__(self):
		self.model = 'apple'	# Instance Variable
	
	def show_model(self):		# Instance Method
		print(self.model)		# Accessing Instance Variable

		
realme = Mobile()
realme.show_model()
	
