import task5defs as defs

path1 = "py/sem4/5_1.txt" # че сжимаем
path2 = "py/sem4/5_2.txt" # сжатое
path3 = "py/sem4/5_3.txt" # разжатое
temp_list = list()

def zip_file():
    temp_list = defs.readfile(path1) # Считали текст для сжатия
    temp_list = defs.zip_list(temp_list) # сжали
    defs.rewrite(temp_list,path2) # пожатое записали в файл