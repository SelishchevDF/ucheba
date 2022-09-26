# 3- Найти расстояние между двумя точками пространства(числа вводятся через пробел)

def isint(s):
    try:
        list(map(int, s.split(' ')))
        return True
    except ValueError:
        return False

def inp():
    q = "qwer"
    while not (isint(q) and len(q.split(' ')) == 2):
        q = input("Введите координаты через пробел ")
    return q

point_1 = list(map(int, inp().split(' ')))
point_2 = list(map(int, inp().split(' ')))

print(((point_2[0] - point_1[0])**2 + (point_2[1] - point_1[1])**2)**.5)