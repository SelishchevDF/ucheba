# Напишите программу, которая принимает на вход координаты двух точек и находит расстояние между ними в 2D пространстве.

# Пример:

# - A (3,6); B (2,1) -> 5,09
# - A (7,-5); B (1,-1) -> 7,21

a = ["q","q"]
b = ["q","q"]

def isfloat(s):
    try:
        float(s)
        return True
    except ValueError:
        return False

def inp(q):
    while not isfloat(q):
        q = input('Введите координату - ')
    return q

j = 0
for i in a:
    a[j] = float(inp(i))
    j += 1

j = 0
for i in b:
    b[j] = float(inp(i))
    j += 1

print("первая точка ",a)
print("вторая точка ",b)

long = (((b[0] - a[0])**2 + (b[1] - a[1])**2)**.5)
print("расстояние - ",long)