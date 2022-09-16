import task5defs as defs

path1 = "py/sem4/5_1.txt" # че сжимаем
path2 = "py/sem4/5_2.txt" # сжатое
path3 = "py/sem4/5_3.txt" # разжатое
temp_list = list()

def unzip():
    temp_list = defs.readfile(path2) # Считали текст для разжатия
    temp_list = defs.unzip(temp_list) #разжали
    defs.rewrite(temp_list,path3) #разжатое записали