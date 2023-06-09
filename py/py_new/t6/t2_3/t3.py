# Напишите функцию в шахматный модуль. Используйте генератор случайных чисел для случайной расстановки ферзей в задаче выше.
# Проверяйте различный случайные варианты и выведите 4 успешных расстановки.
import random
# from t2_3 import t3
import t2

BOARD_SIZE = 8
SECSESSION_SIZE = 4

def random_qeen_list(size):
    res = []
    i = 0
    while i < size:
        qeen = [random.randint(0,size), random.randint(0,size)]
        i += 1
        if qeen in res: i -= 1
        else:res.append(qeen)
    return res
        
def do_this():
    count = 0
    count_tryes = 0
    while count < SECSESSION_SIZE:
        count_tryes += 1
        t_qeen_list = random_qeen_list(BOARD_SIZE)
        if t2.is_safe_all_qeens(t_qeen_list):
            print(t_qeen_list, count_tryes)
            count += 1
            
if __name__ == '__main__':
    do_this()