# Напишите программу, которая принимает две строки вида “a/b” - дробь с числителем и знаменателем.
# Программа должна возвращать сумму и произведение* дробей. Для проверки своего кода используйте модуль fractions.

import fractions
import math

a = "1/3"
b = "6/4"

def convert_to_fraction(string:str):
    res = string.split("/")
    return res

def convert_from_fraction(fraction: list):
    res = str(int(fraction[0])) + "/" + str(int(fraction[1]))
    return res

def fraction_reduction(res:list):
    nod = math.gcd(int(res[0]), int(res[1]))
    res_fraction = [res[0] / nod, res[1] / nod]
    return res_fraction

def sum_of_fractions(list_a:list, list_b:list):
    fraction_a = [int(list_a[0]) * int(list_b[1]), int(list_a[1]) * int(list_b[1])]
    fraction_b = [int(list_b[0]) * int(list_a[1]), int(list_b[1]) * int(list_a[1])]
    res = fraction_reduction([fraction_a[0] + fraction_b[0],fraction_a[1]])
    return res

def mult_of_fractions(list_a:list, list_b:list):
    res = fraction_reduction([int(list_a[0]) * int(list_b[0]), int(list_a[1]) * int(list_b[1])])
    return res

res_sum = (convert_from_fraction(fraction_reduction(sum_of_fractions(convert_to_fraction(a), convert_to_fraction(b)))))
res_mult = (convert_from_fraction(fraction_reduction(mult_of_fractions(convert_to_fraction(a), convert_to_fraction(b)))))
res_sum_fraction = fractions.Fraction(a) + fractions.Fraction(b)
res_mult_fraction = fractions.Fraction(a) * fractions.Fraction(b)
if res_sum == str(res_sum_fraction) and res_mult == str(res_mult_fraction):
    print (res_sum, res_mult)

