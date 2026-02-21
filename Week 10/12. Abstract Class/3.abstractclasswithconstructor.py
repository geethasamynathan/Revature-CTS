from abc import ABC, abstractmethod

class AbstractBase(ABC):
    def __init__(self, value):
        self.value = value  # Constructor initializes instance variable
        print("AbstractBase constructor called")

    @abstractmethod
    def show(self):
        pass  # Must be implemented by subclass

class ConcreteClass(AbstractBase):
    def __init__(self, value, extra):
        super().__init__(value)  # Calls AbstractBase constructor
        self.extra = extra  # Additional initialization
        print("ConcreteClass constructor called")

    def show(self):
        print(f"Value: {self.value}, Extra: {self.extra}")

# Instantiating subclass (calls both constructors)
obj = ConcreteClass(10, "extra data")
obj.show()
