class Father:
    def __init__(self):
        super().__init__()
        print('father class constructor')
    def show_father(self):
        print('father class method')
class Mother:
    def __init__(self):
        super().__init__()
        print('Mother constructor')
    def show_mom(self):
        
        print('mother method')
class Son(Father,Mother):
    def __init__(self):
        super().__init__()
        print('son class constructor')
    def show_son(self):
        
        print('son class method')


s=Son()
s.show_father()
s.show_mom()
s.show_son()