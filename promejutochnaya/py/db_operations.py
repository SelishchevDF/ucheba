import random
import CONST
import main_defs
import os.path
import datetime as DT

def db_parse():
    """парсинг базы. читает файл и возвращает содержимое в виде list = [[id1,date1,title1,msg1], [id2,date2,title2,msg2],  ...] """
    temp_data = list()
    temp_data_splited = list()
    
    # читаем файл
    with open (CONST.PATH, 'r', encoding='utf-8') as data:
        for line in data: temp_data.append(line)
        
    # разбиваем строки в список
    for i in temp_data:
        temp_list = i.split(';')
        temp_list[-1] = temp_list[-1][:-1:] # удаляет /n в конце последнего элемента списка, вообще любой элемент))) держи в базе переход на новую строку
        temp_data_splited.append(temp_list)
    return temp_data_splited[1::]

def find_id(id):
    """ищет в базе по идентификатору"""
    try:
        if int(id) in range(1,CONST.MAX_ID+1): # проверяем вероятность наличия id в базе
            temp_list = db_parse()
            for i in temp_list:
                if i[0] == str(id):               
                    return [i]
            return CONST.NO_COINCIDE 
        else: return CONST.ERROR
    except: return CONST.ERROR
    
def db_item_del(id_from_user):
    """ищет в базе по идентификатору и удаляет елемент из списка, возвращает что удалил если удалось"""
    try:
        if int(id_from_user) in range(1,CONST.MAX_ID+1): # проверяем вероятность наличия id в базе
            list_for_item_del = db_parse()
            deleted_item = []
            
            # ищем и удаляем элемент из списка
            for i in list_for_item_del:
                if (str(id_from_user) == i[0]):
                    deleted_item = i
                    list_for_item_del.remove(i)
                    
            # если элемент найден и удален, то перезаписываем измененную базу
            if deleted_item != []:                
                list_write(list_for_item_del)
                return [deleted_item] 
            else: return CONST.NO_COINCIDE
        else: return CONST.ERROR
    except: return CONST.ERROR
    
def list_write(list_for_rewrite):
    """записывает список в файл"""
    # готовим список к записи
    for i in range(len(list_for_rewrite)):
        for j in range(len(list_for_rewrite[i])):
            list_for_rewrite[i][j] = list_for_rewrite[i][j] + ";"
        list_for_rewrite[i][-1] = list_for_rewrite[i][-1][:len(list_for_rewrite[i][j])-1:] + "\n"

    # записываем в файл заголовок, потом список
    with open (CONST.PATH, 'w', encoding='utf-8') as data:
        for i in CONST.HEADER[:-1:]:
            data.write(i + ";")
        data.write(CONST.HEADER[-1] + "\n")
        for i in list_for_rewrite:
            data.writelines(i)

def db_input(user_data):
    """дописывает в конец базы строку"""
    # готовим строку к записи
    user_data_wr = list()
    for i in range(0, len(user_data)-1):
        user_data_wr.append(user_data[i]+";")
    user_data_wr.append(user_data[-1]+"\n") 
    
    with open (CONST.PATH, 'a', encoding='utf-8') as data:
            data.writelines(user_data_wr)
    return [user_data]

def get_id():
    """генерирует уникальный идентификатор и проверяет место в базе"""
    while True:
        id = str(random.randint(1, CONST.MAX_ID))
        count = 0
        count_exception = 0
        for i in db_parse():  
            count_exception = count_exception + 1
            if count_exception == CONST.MAX_ID: 
                print("место кончилось")
                exit()
            if i[0] == id:
                count = count + 1                
                id = str(random.randint(1, CONST.MAX_ID))
        if count == 0: break                  
    return id
                     
def get_user_data():
    """собирает строку для записи в базу"""
    user_data = list()
    user_data.append(str(get_id()))
    user_data.append(main_defs.now_time())
    user_data.append(main_defs.user_input(CONST.GET_TITLE))
    user_data.append(main_defs.user_input(CONST.GET_MSG))
    return user_data

def db_check():
    """создает базу, если ее нет"""
    if not os.path.exists(CONST.PATH):
        with open (CONST.PATH, 'w', encoding='utf-8') as data:
            for i in CONST.HEADER[:-1:]: data.write(i + ";")
            data.write(CONST.HEADER[-1] + "\n")
            
def db_edit_note(old_note):
    """редактирует запись в базе"""
    temp_list = db_parse()    
    for i in temp_list: 
        if str(i[0]) == str(old_note[0][0]):
            i[1] = main_defs.now_time()
            i[2] = main_defs.user_input(CONST.GET_TITLE)
            i[3] = main_defs.user_input(CONST.GET_MSG)
            new_note = i                   
    list_write(temp_list)
    return [new_note]
    
def db_date_find(start, stop):
    """делает поиск по дате"""
    if start <= stop:
        temp_list = db_parse()
        finded_list = []
        for i in temp_list:
            date = DT.datetime.strptime(i[1], '%Y-%m-%d %H:%M')
            if date >= start and date <= stop:
                finded_list.append(i)
        return finded_list
    else: return CONST.NO_COINCIDE

