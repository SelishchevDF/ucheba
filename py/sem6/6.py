# 6-Сформировать список из N членов последовательности.
# Для N = 5: 1, -3, 9, -27, 81 и т.д.

n = 7
task_list = lambda n: [ (-3)**x for x in range(0, n)]
print(list(task_list(n)))