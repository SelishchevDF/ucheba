# Программа загадывает число от 0 до 1000. Необходимо угадать число за 10 попыток. 
# Программа должна подсказывать “больше” или “меньше” после каждой попытки. 
# Для генерации случайного числа используйте код:
# from random import randint
# num = randint(LOWER_LIMIT, UPPER_LIMIT)


from random import randint

LOWER_LIMIT = 0
UPPER_LIMIT = 1000
NUMBER_OF_ATTEMPTS = 10

i = 0
flag = False

num = randint(LOWER_LIMIT, UPPER_LIMIT)
print(num)

while i < NUMBER_OF_ATTEMPTS:
    print("осталось " + str(NUMBER_OF_ATTEMPTS - i) + " попыток")
    try:
        user_num = int(input("введите число - "))
        if user_num != num:
            if user_num < num:
                print("введенное число меньше нужного")
                i = i + 1
            else:
                print("введенное число больше нужного")
                i = i + 1
        else:
            flag = True
            break
    except:
        print("нужно вводить число")

if flag == True:
    print("Вы угадали")
else: 
    print("Вы НЕ угадали")    