# 5 - Реализуйте RLE алгоритм: реализуйте модуль сжатия и восстановления данных. Входные и выходные данные хранятся в отдельных текстовых файлах.
# файл первый:
# AAAAAAAAAAAABBBBBBBBBBBCCCCCCCCCCDDDDDDEEEEEFFFFG python is sooooooo coooooool
# файл второй:
# сжатый текст.

path1 = "py/sem4/5_1.txt" # че сжимаем
path2 = "py/sem4/5_2.txt" # сжатое
path3 = "py/sem4/5_3.txt" # разжатое
temp_list = list()

def readfile(path):
    """считывает строки из файла, записывает в список"""
    temp_data = list()
    with open (path, 'r', encoding='utf-8') as data:
        for line in data:
            temp_data.append(line)
    return temp_data

def zip_list(list_for_zip):
    """сжимает текст считая повторяющиеся символы"""
    zipped_list = list()
    zipped_list_clean = list()
    for i in list_for_zip:
        i = i + " " # пробел для захвата последнего элемента строки
        count = 0
        for j in range(1,len(i)):   
            if (i[j]) == i[j-1]:
                count = count + 1
            else: 
                zipped_list.append(i[j-1])
                zipped_list.append("$" + str(count) + "$")
                count = 0
    for i in zipped_list:
        if i != "$0$":
            zipped_list_clean.append(i)
    return zipped_list_clean

def rewrite(whatrewrite:list, path):
    """перезаписывает файл списком, каждый элемент с новой строки """
    with open (path, 'w', encoding='utf-8') as data:
        for i in whatrewrite:
            data.writelines(i)  

def unzip(zipped_list):
    """разжали"""
    unzipped_list = list()
    temp_str = str()
    for i in zipped_list:
        j = 0
        while j < len(i):
            if i[j] == "$":
                count = 0
                j = j+1
                while i[j] != "$":
                    temp_str = temp_str + i[j]
                    j = j + 1
                    count = count + 1
                for m in range(0, int(temp_str)):
                    unzipped_list.append(i[j- 2 - count])
                temp_str = str()
                j= j + 1
            else:
                unzipped_list.append(i[j])
                j = j + 1
    return unzipped_list   





temp_list = readfile(path1) # Считали текст для сжатия
temp_list = zip_list(temp_list) # сжали
rewrite(temp_list,path2) # пожатое записали в файл
temp_list = readfile(path2) # Считали текст для разжатия
print(temp_list)
temp_list = unzip(temp_list) #разжали
print(temp_list)
rewrite(temp_list,path3) #разжатое записали