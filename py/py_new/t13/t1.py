from t1_exceptions import UserTypeError

class Triangle:
    a = None
    b = None
    c = None

    def __init__(self, a:int, b:int, c:int):
        if a + b <= c or a + c <= b or b + c <= a:
            raise UserTypeError(self.__class__.__name__)
        else:
            self.a = a
            self.b = b
            self.c = c
    
    def __str__(self):
        return f'A={self.a} B={self.b} C={self.c}'
            
abc = Triangle(1,2,3) 
print(abc)
        