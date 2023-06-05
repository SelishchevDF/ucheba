# Создайте функцию генератор чисел Фибоначчи (см. Википедию)

def fibonachy(limit: int):
    f = [0, 1]
    while limit > 0:
        yield f[-1]
        f.append(f[-1] + f[-2])
        limit -= 1


for number in fibonachy(5):
    print(number)