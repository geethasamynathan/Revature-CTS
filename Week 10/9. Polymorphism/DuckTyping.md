# Duck Typing in Python and Polymorphism
Duck typing is a concept related to polymorphism in programming, particularly in dynamically typed languages like Python. The idea behind duck typing is that an object's suitability for use is determined by the presence of methods and properties rather than the object's actual type. This is often summarized by the phrase:

`"If it looks like a duck, swims like a duck, and quacks like a duck, it probably is a duck."`

In Python, this means that you don’t need to explicitly check the type of an object (like you would in statically typed languages). Instead, you rely on whether the object can perform the necessary actions or methods (i.e., if the object behaves as expected).

##  Polymorphism in Duck Typing
Polymorphism allows objects of different types to be treated as instances of the same class through a shared interface (method names). In the case of duck typing, polymorphism is achieved not by inheritance but by ensuring that objects implement the necessary methods, regardless of their class or type.

Real-World Example: A Payment System
Consider a real-world e-commerce payment system where you can make payments using various methods like CreditCard, PayPal, and Bitcoin. Each of these payment methods may be different, but as long as they implement a process_payment() method, we can handle them uniformly.

Here’s a Python example using duck typing:

python
Copy
# Defining the classes for different payment methods

class CreditCard:
    def __init__(self, number, expiry_date):
        self.number = number
        self.expiry_date = expiry_date

    def process_payment(self, amount):
        print(f"Processing {amount} payment through Credit Card")
        # Payment logic for Credit Card

class PayPal:
    def __init__(self, email):
        self.email = email

    def process_payment(self, amount):
        print(f"Processing {amount} payment through PayPal")
        # Payment logic for PayPal

class Bitcoin:
    def __init__(self, wallet_address):
        self.wallet_address = wallet_address

    def process_payment(self, amount):
        print(f"Processing {amount} payment through Bitcoin")
        # Payment logic for Bitcoin

# Function that can process payments using any of the payment methods
def process_payment(payment_method, amount):
    # We don't care what type of payment method it is (CreditCard, PayPal, or Bitcoin),
    # as long as it has a method process_payment
    payment_method.process_payment(amount)

# Creating different payment method objects
credit_card = CreditCard("1234-5678-9876-5432", "12/25")
paypal = PayPal("user@example.com")
bitcoin = Bitcoin("1A1zP1eP5QGefi2DMPTfTL5SLmv7DivfNa")

# Processing payments using different methods
process_payment(credit_card, 100)
process_payment(paypal, 50)
process_payment(bitcoin, 200)
Output:
Copy
Processing 100 payment through Credit Card
Processing 50 payment through PayPal
Processing 200 payment through Bitcoin
Explanation:
Duck Typing in Action:

All payment methods (CreditCard, PayPal, and Bitcoin) implement the process_payment() method.
The function process_payment(payment_method, amount) does not care about the specific class of the payment_method object. It only cares that the object has a process_payment() method.
This is the essence of duck typing: Python checks that the object has the necessary methods (like process_payment()), and if it does, it allows the object to be used in that context.
Polymorphism:

Different classes (CreditCard, PayPal, Bitcoin) represent different payment methods, but they all provide a method process_payment(). This is an example of polymorphism because the same function (process_payment) is being used on different types of objects.
The actual type of the object doesn't matter; Python just looks for the process_payment() method, which is common to all payment methods.
Key Points of Duck Typing:
No Type Checking: Python does not check the type of the object. Instead, it checks if the object has the necessary methods or properties. If it does, the object can be used in that context.
Flexibility: Duck typing makes Python code flexible and adaptable, as objects don’t need to explicitly inherit from a common base class or implement an interface (as required in statically typed languages).
Polymorphism: Different types of objects can be treated uniformly as long as they share the same behavior (method names and functionality). This is a key feature of polymorphism in Python.
Advantages of Duck Typing:
Less rigid: You don’t need to define interfaces or enforce inheritance hierarchies, making the code more flexible and concise.
Easier to extend: You can add new classes that implement the required methods without modifying the existing code.
Disadvantages of Duck Typing:
Runtime errors: Since Python doesn’t check the types of objects at compile time, you might run into errors at runtime if an object doesn’t implement the required method.
Less explicit: Without a clear interface or type constraints, it can be harder to understand what methods an object is supposed to have, especially in large codebases.
Conclusion:
Duck typing in Python is a form of polymorphism that relies on the presence of methods or properties rather than the actual type of an object. This allows different types of objects to be treated in the same way as long as they implement the necessary methods, which can be especially useful in dynamic and flexible systems like an e-commerce platform.