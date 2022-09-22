# 2- Создайте программу для игры с конфетами человек против человека.
# Условие задачи: На столе лежит 2021 конфета(или сколько вы зададите). Играют два игрока делая ход друг после друга. Первый ход определяется жеребьёвкой. За один ход можно забрать не более чем 28 конфет(или сколько вы зададите). Тот, кто берет последнюю конфету - проиграл.
# Предусмотрите последний ход, ибо там конфет остается меньше.

# a) Добавьте игру против бота
# b) Подумайте как наделить бота "интеллектом"
import random
answer = 0
first_player_name =""
second_player_name =""
first_player =""
second_player =""
number_coffets = 0 
number_coffets_at_tern = 0

# Игра c игроком
def game_pvp(fp,sp,num,num_at_tern):
    count = 0
    while num > 0:
        if num < num_at_tern: num_at_tern = num
        num = tern(fp,num,num_at_tern)
        count += 1
        if num > 0:
            if num < num_at_tern: num_at_tern = num
            num = tern(sp,num,num_at_tern)
            count +=1
    if count%2 == 0: print(f"победил {fp}")
    else : print(f'победил {sp}')

# игра с ботом
def game_pve(fp,sp,num,num_at_tern):
    if fp == "James Bond":
        count = 0
        while num > 0:
            if num < num_at_tern: num_at_tern = num
            num = tern_bot(fp,num,num_at_tern)
            count += 1
            if num > 0:
                if num < num_at_tern: num_at_tern = num
                num = tern(sp,num,num_at_tern)
                count +=1
        if count%2 == 0: print(f"победил {fp}")
        else : print(f'победил {sp}')
    else:
        count = 0
        while num > 0:
            if num < num_at_tern: num_at_tern = num
            num = tern(fp,num,num_at_tern)
            count += 1
            if num > 0:
                if num < num_at_tern: num_at_tern = num
                num = tern_bot(sp,num,num_at_tern)
                count +=1
        if count%2 == 0: print(f"победил {fp}")
        else : print(f'победил {sp}')

# Ход человека    
def tern(player, num, num_at_tern):
    print(f"ходит {player}, конфет осталось {num}")
    num = num - inp(0,0,num_at_tern+1,"сколько конфет взять?")
    return num

# Ход умного бота
def tern_bot(player,num,num_at_tern):
    print(f"ходит {player}, конфет осталось {num}")
    if num < num_at_tern+1:
        bot_take = num-1   
    else:
        bot_take = random.randint(1,num_at_tern)
    print(f"игрок {player} взял {bot_take}")
    num = num - bot_take
    return num

def isint(s):
    """проверка преобразования в число"""
    try:
        int(s)
        return True
    except ValueError:
        return False

def inp(q, start_range, end_range, qstring, condition = lambda q, start_range, end_range: start_range < int(q) < end_range):
    """проверка ввода корректного числа при выборе чегонить
    parametrs
    -----
    start_range : int
        c какого числа можно вводить, не включая  
    end_range: int
        до какого числа можно вводить, не включая
    """
    while not (isint(q) and bool(condition(q, start_range, end_range))): q = input(f'{qstring}' + " ")
    return int(q)

# Выбираем как играть
answer = inp(0,0,3," 1 - игра с ботом\n 2 - против игрока")
print(answer)

# Представляемся
first_player_name = input("имя первого игрока -")
if answer == 2:
    second_player_name = input("имя первого игрока -")
else: second_player_name = "James Bond"

# Жеребьёвка
if random.randint(1,2) == 1:
    first_player = first_player_name
    second_player = second_player_name
else:
    first_player = second_player_name
    second_player = first_player_name
print(f'первый ходит {first_player}, второй ходит {second_player},')

# правила игры
number_coffets = inp(0, 1, 10000, 'Введите число конфет на столе от 2 до 9999 -')
number_coffets_at_tern = inp(0, 0, number_coffets, f'число конфет которые можно брать за ход (меньше общего числа конфет плз {number_coffets}) -')

if answer == 2:
    game_pvp(first_player, second_player, number_coffets, number_coffets_at_tern)
else: game_pve(first_player, second_player, number_coffets, number_coffets_at_tern)
