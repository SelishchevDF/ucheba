# 2-Напишите программу, которая найдёт произведение пар чисел списка. Парой считаем первый и последний элемент, второй и предпоследний и т.д.

# Пример:

# [2, 3, 4, 5, 6] => [12, 15, 16];
# [2, 3, 5, 6] => [12, 15]

import random

def product_pairs(x:list):
    """функция считает произведение пар чисел списка. Парой считаем первый и последний элемент, второй и предпоследний и т.д. """
    n = 0
    m = -1
    pp = list()
    for i in range(round(len(x)/2)):
        pp.append(x[n] * x[m])
        n += 1
        m -= 1
    return pp

numbers = []
for i in range(7):
    numbers.append(random.randint(0,6))
print(numbers)
print(product_pairs(numbers))