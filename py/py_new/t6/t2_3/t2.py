# Добавьте в пакет, созданный на семинаре шахматный модуль.
# Внутри него напишите код, решающий задачу о 8 ферзях.
# Известно, что на доске 8×8 можно расставить 8 ферзей так, чтобы они не били друг друга.
# Вам дана расстановка 8 ферзей на доске, определите, есть ли среди них пара бьющих друг друга.
# Программа получает на вход восемь пар чисел, каждое число от 1 до 8 - координаты 8 ферзей.
# Если ферзи не бьют друг друга верните истину, а если бьют - ложь.

def is_safe_all_qeens(qeen_list):
    flag = 0
    for qeen in qeen_list:

        for i in range(qeen[0] + 1 , len(qeen_list)):
            if [i, qeen[1]] in qeen_list: flag += 1
            
        for j in range(qeen[1] + 1, len(qeen_list)):
            if [qeen[0], j] in qeen_list: flag += 1

        # "/"
        i = 1
        j = 1
        while qeen[0] + i <= len(qeen_list) and qeen[1] - j <= 0:
            if [qeen[0] + i, qeen[1] - j] in qeen_list: flag += 1
            i += 1
            j += 1
        
        # "\"
        i = 1
        j = 1
        while qeen[0] + i <= len(qeen_list) and qeen[1] + j <= len(qeen_list):
            if [qeen[0] + i, qeen[1] + j] in qeen_list: flag += 1
            i += 1
            j += 1
        
    if flag == 0: 
        return True 
    else: return False
