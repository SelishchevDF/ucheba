# Напишите код, который запрашивает число и сообщает является ли оно простым или составным.
# Используйте правило для проверки: “Число является простым, если делится нацело только на единицу и на себя”.
# Сделайте ограничение на ввод отрицательных чисел и чисел больше 100 тысяч.

num = -1
num_max = 100000

def input_num(num, num_max):
    while num == None or num < 0 or num > num_max:
        try:
            num = int(input("Введите неотрицательное число и меньше " + str(num_max) + " - "))
        except:
            num = None
    return num

def is_prime(x):
    for i in range(2, (x//2)+1):
        if x % i == 0:
            return False
    return True

if is_prime(input_num(num, num_max)):
    print("Prime")
else:
    print("NOT prime")