# 1 - Напишите программу, которая принимает на вход вещественное число и показывает сумму его цифр. Учтите, что числа могут быть отрицательными

# Пример:

# 67.82 -> 23
# 0.56 -> 11

num = "a"
sum = 0

def isfloat(s):
    try:
        float(s)
        return True
    except ValueError:
        return False

while not isfloat(num):
    num = input('Введите число - ')

for i in num:
    if i == ".":
        i = 0
    elif i == "-":
        i = 0
    else:
        sum = sum + int(i)

print(sum)