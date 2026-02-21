# # public Acees_specifier
# class PublicExample:
#     def __init__(self, name):
#         self.name = name  # Public variable

#     def display(self):
#         print("Name:", self.name)
        
# obj=PublicExample("Geetha")
# obj.display()

## Protected demo
# class ProtectedExample:
#     def __init__(self, age):
#         self._age = age  # Protected variable

#     def _display(self):  # Protected method
#         print("Age:", self._age)

# class SubClass(ProtectedExample):
#     def show(self):
#         print("Accessing Protected:", self._age)  # ✅ Allowed in subclass
#         self._display()  # ✅ Allowed in subclass

# # Accessing protected members
# obj = SubClass(25)
# obj.show()

class PrivateExample:
    def __init__(self, salary):
        self.__salary = salary  # Private variable

    def __display(self):  # Private method
        print("Salary:", self.__salary)

    def access_private(self):
        self.__display()  # ✅ Allowed inside class

# Accessing private members
obj = PrivateExample(50000)

# Direct access (❌ Not allowed)
# print(obj.__salary)  # AttributeError

# Name mangling (✅ Allowed)
print(obj._PrivateExample__salary)  # Works, but not recommended

# Private method call (❌ Not allowed)
# obj.__display()  # AttributeError

# Private method accessed via another method (✅ Allowed)
obj.access_private()