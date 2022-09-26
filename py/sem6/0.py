# # 0 - дорешать задачу с семинара(она в обсуждениях)

# Задание с семинара
# Напишите программу вычисления арифметического выражения заданного строкой.
# Используйте операции +,-,/,. приоритет операций стандартный.
# Дополнительное задание: Добавьте возможность использования скобок, меняющих приоритет операций
# *Пример:
# 2+2 => 4;
# 1+2*3 => 7;

# 10/2*5 => 25;
# 10 * 5 * => недостаточно числовых данных
# -5 + 5 => 0
# два + три => неправильный ввод: нужны числа
# (2+((5-3)*(16-14)))/3 => 2
# (256 - 194 => некорректная запись скобок

parsed_list = list()
parsed_string = ""
splited_parsed_list = list()
operators = ("*", "/", "+", "-")

def mathematical(list_for_math):
    """ если в списке есть * или / проходит по списку, если элемент != * или / - сваливает его в темповый список, если == * или / - удаляет 
    полседний элемент из темпового списка и вставляет в него результат математической операции на которую наткнулся,
    дописывает в темповый список оставшуюся часть первоначального списка"""
    list_for_math_rec = list()
    if len(list_for_math) > 1:
        if ("*" in list_for_math or "/" in list_for_math):
            for i in list_for_math:
                if i == "*":
                    list_for_math_rec.pop(len(list_for_math_rec) - 1)
                    list_for_math_rec.append(int(list_for_math[list_for_math.index(i)-1]) * int(list_for_math[list_for_math.index(i)+1]))
                    for j in range(list_for_math.index(i) + 2,len(list_for_math)):
                        list_for_math_rec.append(list_for_math[j])
                    break
                elif i == "/":
                    list_for_math_rec.pop(len(list_for_math_rec) - 1)
                    list_for_math_rec.append(int(list_for_math[list_for_math.index(i)-1]) / int(list_for_math[list_for_math.index(i)+1]))
                    for j in range(list_for_math.index(i) + 2,len(list_for_math)):
                        list_for_math_rec.append(list_for_math[j])
                    break
                else: list_for_math_rec.append(i)
        elif ("+" in list_for_math or "-" in list_for_math):
            for i in list_for_math:
                if i == "+":
                    list_for_math_rec.pop(len(list_for_math_rec) - 1)
                    list_for_math_rec.append(int(list_for_math[list_for_math.index(i)-1]) + int(list_for_math[list_for_math.index(i)+1]))
                    for j in range(list_for_math.index(i) + 2,len(list_for_math)):
                        list_for_math_rec.append(list_for_math[j])
                    break
                elif i == "-":
                    list_for_math_rec.pop(len(list_for_math_rec) - 1)
                    list_for_math_rec.append(int(list_for_math[list_for_math.index(i)-1]) - int(list_for_math[list_for_math.index(i)+1]))
                    for j in range(list_for_math.index(i) + 2,len(list_for_math)):
                        list_for_math_rec.append(list_for_math[j])
                    break
                else: list_for_math_rec.append(i)            
    else:
        print(list_for_math) 
        return list_for_math
    mathematical(list_for_math_rec)

def iscorrect(string_for_parse):
    """ проверка ввода чисел и числовых данных"""
    parsed_list_temp = list()
    for i in range(len(string_for_parse)):
        if string_for_parse[i] not in operators:
            parsed_list_temp.append(string_for_parse[i])
    try:
        for i in parsed_list_temp: int(i)
        return True
    except ValueError:
        print("вводите корректно - ")
        return False
   
print("вводите выражение")
string_for_parse = input()
while not iscorrect(string_for_parse):
    string_for_parse = input()

for i in range(len(string_for_parse)):
    if string_for_parse[i] in operators:
        parsed_list.append("#"+string_for_parse[i]+"#")
    else: 
        parsed_list.append(string_for_parse[i])
parsed_string = "".join(parsed_list)
parsed_string.replace(" ", "")
splited_parsed_list = parsed_string.split("#")
if splited_parsed_list[0] == "" and splited_parsed_list[1]== "-":
    splited_parsed_list[2] = "-" + splited_parsed_list[2]
    splited_parsed_list.remove("")
    splited_parsed_list.remove("-")

mathematical(splited_parsed_list)





