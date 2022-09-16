# 2 - Задайте последовательность чисел. Напишите программу, которая выведет список неповторяющихся элементов исходной последовательности. Не использовать множества.
# [1,1,1,1,2,2,2,3,3,3,4] -> [1,2,3,4]

import random


numbers = []
for i in range(21):
    numbers.append(random.randint(1, 6))
print(numbers)

def no_duble(x:list):
    """функция принимает на вход список и выдает список без повторяющихся элементов"""
    no_duble_list = list()
    for i in x :
        if i not in no_duble_list:
            no_duble_list.append(i)
    print(no_duble_list)

no_duble(numbers)
