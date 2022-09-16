# 3 - В файле, содержащем фамилии студентов и их оценки, изменить на прописные буквы фамилии тех студентов, которые имеют средний балл более «4».
# Нужно перезаписать файл.
# Пример:
# Ангела Меркель 5
# Андрей Валетов 5
# Фредди Меркури 3
# Анастасия Пономарева 4

# Программа выдаст:
# АНГЕЛА МЕРКЕЛЬ 5
# АНДРЕЙ ВАЛЕТОВ 5
# Фредди Меркури 3
# Анастасия Пономарева 4

path1 = "py/sem4/3_1.txt"
path2 = "py/sem4/3_2.txt"
temp_list = list()

def readfile(path):
    """считывает строки из файла, записывает в список, если в конце строки стоит перенос \n, убирает его"""
    temp_data = list()
    with open (path, 'r', encoding='utf-8') as data:
        for line in data:
            if "\n" in line:
                temp_str = line.replace("\n", "")
                temp_data.append(temp_str)
            else: temp_data.append(line)
    return temp_data

def check_for_mark(list_check:list):
    """Берет лист, построчно отрезает пробелы справа, если выполняется условие что после отрезания пробелов
    последний элемент строки конвертится в число и больше 4, делает строку большим регистром, все записывает в другой список"""
    list_after_check = list()
    for i in list_check:
        temp_str = str.rstrip(i)
        if int(i[-1]) > 4:
            big_str = str.upper(temp_str)
            list_after_check.append(big_str)
        else: list_after_check.append(temp_str)
    return list_after_check

def rewrite(whatrewrite:list, path):
    """перезаписывает файл списком, каждый элемент с новой строки """
    with open (path, 'w', encoding='utf-8') as data:
        for i in whatrewrite:
            data.writelines(i+"\n")

temp_list = readfile(path1)
print(temp_list)
temp_list = check_for_mark(temp_list)
print(temp_list)
rewrite(temp_list, path2)





