# Напишите программу, которая принимает на вход цифру, обозначающую день недели, и проверяет, является ли этот день выходным.

# Пример:

# - 6 -> да
# - 7 -> да
# - 1 -> нет

day = "0"

def isint(s):
    try:
        int(s)
        return True
    except ValueError:
        return False

while not (isint(day) and (0 <int(day)< 8) ):
    day = input('Введите номер дня недели - ')

if (0 < int(day) < 6):
    print("будний день")
else:
    print("Выходной день")
    