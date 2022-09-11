# 2 - Напишите программу, которая принимает на вход число N и выдает набор произведений (набор - это список) чисел от 1 до N.
# Не используйте функцию math.factorial.
# Добавьте проверку числа N: чтобы пользователь не мог ввести буквы.

# Пример:
# - пусть N = 4, тогда [ 1, 2, 6, 24 ] (1, 1*2, 1*2*3, 1*2*3*4)

num = "a"
fac = 1
fac_list = list()

def isint(s):
    try:
        int(s)
        return True
    except ValueError:
        return False

while not (isint(num) and int(num) > 0):
    num = input('Введите число - ')

num = int(num)

for i in range(1, num + 1):
    fac = fac * i
    fac_list.append(fac)

print(fac_list)
