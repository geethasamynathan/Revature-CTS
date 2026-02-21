from abc import ABC,abstractmethod

class Father:
    def display(self):
        print(' I am display from Father \
abstract classs')
    # @abstractmethod
    def myabstractmethod(self):
        pass   
    
class Child(Father):
    def myabstractmethod(self):
        print(' Hello from Child implementing \
 abstract method of Father')

    def show(self):
        print('I am from child class')
        
c=Child()
c.display() 
c.myabstractmethod()
c.show()

f =Father()
f.display()
f.myabstractmethod()
       
 