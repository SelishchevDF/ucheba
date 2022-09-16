# 5 - Реализуйте RLE алгоритм: реализуйте модуль сжатия и восстановления данных. Входные и выходные данные хранятся в отдельных текстовых файлах.
# файл первый:
# AAAAAAAAAAAABBBBBBBBBBBCCCCCCCCCCDDDDDDEEEEEFFFFG python is sooooooo coooooool
# файл второй:
# сжатый текст.

import task5unzip, task5zip

answer = 0

def isint(s):
    """проверка преобразования в число"""
    try:
        int(s)
        return True
    except ValueError:
        return False

def inp(q):
    """проверка ввода корректного числа"""
    while not (isint(q) and (0 < int(q) < 3)):
        q = input("выберете 1 - сжимать, 2 - разжимать ")
    return q

answer = int(inp(answer))
if answer == 1:
    task5zip.zip_file()
else:
    task5unzip.unzip()