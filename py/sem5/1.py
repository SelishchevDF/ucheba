# 1- Напишите программу, удаляющую из текста все слова, содержащие ""абв"".
# 'абвгдейка - это передача' = >" - это передача"

path1 = "py/sem5/1_1.txt"
path2 = "py/sem5/1_2.txt"
temp_list = list()
what_delete = "абв"

def read_file(path):
    """считывает строки из файла, записывает в список"""
    temp_data = list()
    with open (path, 'r', encoding='utf-8') as data:
        for line in data: temp_data.append(line)
    return temp_data

def edit_text(red_list:list,del_word):
    """разбивает список на слова по пробелу, если в слове есть кодовое слово, то меняет его на ''"""
    temp_list_edited = list()
    temp_list = list()
    for i in red_list:
        temp_list = i.split()
        for j in temp_list:
            if del_word in j:
                if "\n" in j: j = "\n"
                j = ""
            temp_list_edited.append(j+" ")
        temp_list_edited.append("\n")
    return(temp_list_edited)

def rewrite(whatrewrite:list, path):
    """перезаписывает файл списком, каждый элемент с новой строки """
    with open (path, 'w', encoding='utf-8') as data:
        for i in whatrewrite:
            data.writelines(i)

temp_list = read_file(path1)
temp_list = edit_text(temp_list,what_delete)
rewrite(temp_list, path2)