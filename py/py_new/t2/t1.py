# Напишите программу, которая получает целое число и возвращает его шестнадцатеричное строковое представление.
# Функцию hex используйте для проверки своего результата.

# десятичное число для перевода
number = 10000

# основание системы исчисления
base = None

# перевод десятичного числа в любую СИ до 36
def convert_to(number:int, base:int):
    digits = '0123456789abcdefghijklmnopqrstuvwxyz'
    if base > len(digits): return None
    result = ''
    while number > 0:
        result = digits[number % base] + result
        number //= base
    return result

hex_result = '0x' + str(convert_to(number, base = 16))
if hex_result == hex(number):
    print(hex_result)