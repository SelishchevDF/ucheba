from t1_ani import Dog, Cat, Fish, Animal

class AnimalsFabric:
    
    def create_animal(type, name, age=None, *args):
        if type == 'dog':
            return Dog(type, name, age, *args)
        elif type == 'cat':
            return Cat(type, name, age, *args)
        elif type == 'fish':
            return Fish(type, name, age, *args)
        else:
            return Animal(type, name, age)
        
        
        