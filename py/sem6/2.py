# 2- Найти сумму чисел списка стоящих на нечетной позиции

num_list = [0,1,2,3,4,5,6,7,8]

print(sum(list(map(int, num_list))[1::2]))