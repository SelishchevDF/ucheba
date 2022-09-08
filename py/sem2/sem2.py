# 1. Напишите программу, которая принимает на вход число N и выдаёт последовательность из N членов в виде списка
# *Пример:*
# - Для N = 5: 1, -3, 9, -27, 81

# 2.Найти сумму элементов массива, лежащих между максимальным и минимальным по значению элементами

# 3.Найдите количество элементов массива, которые отличны от наибольшего элемента не более чем на 10% ( 10% от наибольшего)

# совпадает с примером
# n = int(input("Введи число - "))
# i = 0
# count = 1
# otvet = [1]
# while i < (n - 1):
#     count = count * -3
#     otvet.append(count)
#     i += 1
# print(otvet)
    
# n = int(input("Введи число - "))
# i = 1
# count = -3
# otvet = [1]
# while i < (n):
#     count = count ** i
#     otvet.append(count)
#     i += 1
# print(otvet)

arr = [2, 5, 3, 4, 1]
min_Index = 0
max_index = 0
val = 0

val = min(arr)
min_Index = arr.index(val)

val = max(arr)
max_Index = arr.index(val)

summ = arr[min_Index + 1 ]

while min_Index < max_Index - 1:
    min_Index = min_Index + 1
    print("текущее значение",arr[min_Index])
    summ = summ + arr[min_Index + 1]
else:
    summ = summ - arr[min_Index + 1]
print(summ)