# Напишите функцию группового переименования файлов. Она должна:
#   принимать параметр желаемое конечное имя файлов. При переименовании в конце имени добавляется порядковый номер.
#   принимать параметр количество цифр в порядковом номере.
#   принимать параметр расширение исходного файла. Переименование должно работать только для этих файлов внутри каталога.
#   принимать параметр расширение конечного файла.
#   принимать диапазон сохраняемого оригинального имени. 
# Например для диапазона [3, 6] берутся буквы с 3 по 6 из исходного имени файла.
# К ним прибавляется желаемое конечное имя, если оно передано. Далее счётчик файлов и расширение.  

import os

def new_name_generator(name:str, range_name:list, number_of_digits_in_new_name, count:int, new_extension, new_name = ""):
    
    # get number
    temp_number = []
    i = 0
    while i < number_of_digits_in_new_name:
        temp_number.append("0")
        i += 1
    temp_count = list(str(count))    
    number = []
    i = 0
    j = 0
    while i < len(temp_count):
        number.append(temp_count[i])
        i += 1
    while j < (len(temp_number) - i):
        number.insert(0, temp_number[j])
        j += 1          
    number_string = ""
    for char in number:
        number_string += str(char)
    
    # temp name
    t_n = name.split(".")[0]
    try:
        t_n = t_n[range_name[0]: range_name[1]]
    except: 
        t_n = "ой!"
        return t_n
        
    # generate new name
    tem_new_name = t_n + new_name + number_string + new_extension
    return tem_new_name  
    

def reneme_files(extension, name_range: list, number_of_digits_in_new_name, new_extension, new_name = "", path = "."):
    
    # get file list for rename
    all_files = os.listdir(path)
    files_for_rename = []
    for file in all_files:
        if file.endswith(extension):
            files_for_rename.append(file)
            
    # rename files
    count = 1
    for file in files_for_rename:
        os.rename(file, new_name_generator(file, name_range, number_of_digits_in_new_name, count, new_extension, new_name))
        count += 1


if __name__ == "__main__":       
    reneme_files(".test", [0,5], 5, ".123", "TEST_RUN", path = ".")


