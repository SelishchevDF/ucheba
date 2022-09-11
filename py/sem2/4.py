# 4 - Реализуйте выдачу случайного числа
# не использовать random.randint и вообще библиотеку random
# Можете использовать xor, биты, библиотеку time или datetime (миллисекунды или наносекунды) - для задания случайности
# Учтите, что есть диапазон: от(минимальное) и до (максимальное)

import time

max = "a"
maxstr = "максимум"
min = "a"
minstr = "минимум"

def isint(s):
    try:
        int(s)
        return True
    except ValueError:
        return False

def inp(q,maxormin):
    while not (isint(q) and int(q) >= 0):
        q = input(f"Введите {maxormin} - ")
    return q

def random_number(minimum,maximum):
    now = str(time.time())
    rnd = float(now[::-1][:3:])/1000
    return minimum + rnd*(maximum-minimum)

min = int(inp(min, minstr))
max = int(inp(max, maxstr))

print(random_number(min,max))

