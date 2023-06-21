from t1_fab import AnimalsFabric

dog = AnimalsFabric.create_animal("dog", "sharik", 10, "dvornyaga")
dog.say_something()
print(dog.type, dog.name, dog.age, dog.breed)

cat = AnimalsFabric.create_animal("cat", "basya", 5, "dvornyaga", "description")
dog.say_something()
print(cat.type, cat.name, cat.age, cat.breed, cat.description)

animal = AnimalsFabric.create_animal("animal", "something")
animal.say_something()
print(animal.type, animal.name, animal.age)