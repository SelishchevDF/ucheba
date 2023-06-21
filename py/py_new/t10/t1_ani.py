class Animals:
    
    what_animal_say = None
    
    def __init__(self, type, name, age = None):
        self.type = type
        self.name = name
        self.age = age
        
    def say_something(self):
        print(self.what_animal_say)
        
class Dog(Animals):
    
    what_animal_say = "wuf wuf wuf wuf wuf"
    
    def __init__(self, type, name, age = None, breed = None):
        super().__init__(type, name, age)
        self.breed = breed

class Cat(Animals):
    
    what_animal_say = "meo meo meo meo meo"
    
    def __init__(self, type, name, age = None, breed = None, description = None):
        super().__init__(type, name, age)
        self.breed = breed
        self.description = description
        
class Fish(Animals):
    
    what_animal_say = "???!!!"
    
    def __init__(self, type, name, age = None, scale_color = None, description = None, ):
        super().__init__(type, name, age)

        self.description = description
        self.scale_color = scale_color
        
class Animal(Animals):
    
    def __init__(self, type, name, age = None):
        super().__init__(type, name, age)



