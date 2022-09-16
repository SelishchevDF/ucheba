# 1 - Задайте натуральное число N. Напишите программу, которая составит список простых множителей числа N.
# N = 20 -> [2,5]
# N = 30 -> [2, 3, 5]

import random

num = random.randint(10,51)

def find_multipliers(x:int):
    """функция, которая составит список простых множителей числа N."""
    multipliers_list = []
    for i in range(2,10):
        if x % i == 0:
            count = 0 # для проверки простоты множителя
            for j in range(2,i): 
                if i % j == 0:
                    count = count + 1
            if count == 0:
                multipliers_list.append(i)
    print(multipliers_list)

print(num)
find_multipliers(num)