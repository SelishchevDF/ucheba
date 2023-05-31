# Возьмите задачу о банкомате из семинара 2. Разбейте её на отдельные операции - функции.
# Дополнительно сохраняйте все операции поступления и снятия средств в список.

#Напишите программу банкомат.
#✔ Начальная сумма равна нулю
#✔ Допустимые действия: пополнить, снять, выйти
#✔ Сумма пополнения и снятия кратны 50 у.е.
#✔ Процент за снятие — 1.5% от суммы снятия, но не менее 30 и не более 600 у.е.
#✔ После каждой третей операции пополнения или снятия начисляются проценты - 3%
#✔ Нельзя снять больше, чем на счёте
#✔ При превышении суммы в 5 млн, вычитать налог на богатство 10% перед каждой
#операцией, даже ошибочной
#✔ Любое действие выводит сумму денег

from t3_get_money import get_money
from t3_give_money import give_money

amount_of_money = 0
operations_count = 0

while True:
    print ("1 - снять, 2 - пополнить, q - выйти")
    print ("количество денег - ", amount_of_money)
    user_answer = input("что делаем? ")
    if user_answer == '1':
        amount_of_money, operations_count = get_money(int(input("сколько? ")), amount_of_money, operations_count)
    elif user_answer == '2':
        amount_of_money, operations_count = give_money(int(input("сколько? ")), amount_of_money, operations_count)
    elif user_answer == 'q':
        print('пока!')
        break