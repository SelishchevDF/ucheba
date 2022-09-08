# Напишите программу, которая по заданному номеру четверти, показывает диапазон возможных координат точек в этой четверти (x и y).

quarter = "0"

def isint(s):
    try:
        int(s)
        return True
    except ValueError:
        return False

while not (isint(quarter) and (0 <int(quarter)< 5) ):
    quarter = input('Введите номер четверти - ')
quarter = int(quarter)

if (quarter == 1 ):
    print("перввая четверть - X>0,Y>0")
elif (quarter == 2 ):
    print("вторая четверть - X<0,Y>0")
elif (quarter == 3 ):
    print("третья четверть - X<0,Y<0")
else :
    print("четвертая четверть - X<0,Y>0")