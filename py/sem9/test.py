from ast import Num
import check
import random
global num
num = 0
global user
user = 0
global num_at_tern
num_at_tern = 0
global bot_name
bot_name = 0

def menu():   
    text = input('играть(1) или читать(2)')
    if text == '1':
        print('играем')
        game()
    elif text == '2':
        print('считаем')
        # calc()

def game():
    # запомнили имя игрока
    global user
    user = "ИГРОК"
    num_konf()

def num_konf():
    # выбрали сколько конфет
    global num
    num = input("Сколько будет конфет в игре?")
    if (check.isint(num) and 1 < int(num)):
        print(f'конфет всего {num}')
        num_konf_at_tern()
    else: num_konf()

def num_konf_at_tern():
    # выбрали сколько конфет за ход
    global num
    global num_at_tern
    num_at_tern = input("Сколько конфет можно брать за ход?")
    print(num)
    print(int(num_at_tern) < int(num))
    if (check.isint(num_at_tern) and 0 < int(num_at_tern) and int(num_at_tern) < int(num)):
        print(f'конфет за ход {num_at_tern}')
        draw()
    else:
        num_konf_at_tern()

def draw():
    global bot_name
    bot_name = "БОТЯРА"
    if random.randint(1,2) == 1:
        first_player = user
        bot = bot_name
        print("первый игрок")
        user_tern()
    else:
        first_player = bot_name
        bot = user
        print('первый ботяра')
        bot_tern()

def user_tern():
    global num
    global num_at_tern
    print(f'конфет осталось {num}, сколько взять?')
    num_temp = input()
    if (check.isint(num_temp) and 0 < int(num_temp) < int(num_at_tern)) :
        num = int(num) - int(num_temp)
        print(f'ходил игрок конфет {num}')
        if (int(num) - int(num_temp)) > 0:
            bot_tern()
        else:
            print(f'победил  ~{user}')
    else: user_tern()


def bot_tern():
    global num
    global num_at_tern
    if int(num) < (int(num_at_tern)+1):
        bot_take = int(num)-1   
    else:
        bot_take = random.randint(1,int(num_at_tern))
    print(f'БОТЯРА взял {bot_take}')
    num = int(num) - bot_take
    print(f'ходил бот конфет {num}')
    if (int(num)) > 0:
        user_tern()
    else:
        print(f'победил  ~БОТЯРА')

menu()