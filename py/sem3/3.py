# 3-Задайте список из вещественных чисел. Напишите программу, которая найдёт разницу между максимальным и минимальным значением дробной части элементов.

# Пример:

# [1.1, 1.2, 3.1, 5.17, 10.02] => 0.18 или 18
# [4.07, 5.1, 8.2444, 6.98] - 0.91 или 91

import random

fp = list()

def fractional_part(x:list):
    """берет список из вещественных числел, возвращает список дробных частей"""
    fp = list()
    for i in x:
        fp.append(round((i%1) * 1000))
    return fp


numbers = []
for i in range(7):
    numbers.append(random.randint(100,1000)/100)
print(numbers)
fp = fractional_part(numbers)
print(fp)
print((max(fp) - min(fp))/1000)