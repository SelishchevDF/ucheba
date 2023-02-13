import CONST
import db_operations
import main_defs
import datetime as DT
    
def start_menu():

    while True:

        user_choice = main_defs.user_input(CONST.MAIN_MENU)
        
        if user_choice == "1":
            """посмотреть все"""
            print()
            print("заметки в базе")
            resive_data=db_operations.db_parse()
            main_defs.view_list(resive_data)
            print()
    
        elif user_choice == "2":
            """найти заметку по номеру"""
            print()
            user_choice = main_defs.user_input(CONST.ID_INVITE_FIND)
            print()           
            main_defs.view_list(db_operations.find_id(user_choice))
            print()
            
        elif user_choice == "3":
            """найти заметку по дате"""
            print()
            try:
                date_start = DT.datetime.strptime(main_defs.user_input(CONST.DATE_START), '%d/%m/%Y %H:%M')
                date_stop = DT.datetime.strptime(main_defs.user_input(CONST.DATE_STOP), '%d/%m/%Y %H:%M')
                print()
                main_defs.view_list(db_operations.db_date_find(date_start, date_stop))
            except: print("Неверный формат даты")
            print()
            
        elif user_choice == "4":
            """редактировать заметку"""
            print()
            user_choice = main_defs.user_input(CONST.ID_INVITE_EDIT)
            print()
            old_note = db_operations.find_id(user_choice)
            if old_note != (CONST.ERROR or CONST.NO_COINCIDE):
                new_note = db_operations.db_edit_note(old_note)
                print("заметка изменена")
                main_defs.view_list(new_note)
                print()
            else: main_defs.view_list(old_note)
                     
        elif user_choice == "5":
            """удалить заметку"""
            print()
            user_choice = main_defs.user_input(CONST.ID_INVITE_DELETE)
            print()      
            main_defs.view_list(db_operations.db_item_del(user_choice))
            print()
            
            
        elif user_choice == "6":
            """Добавить заметку"""
            print()
            main_defs.view_list(db_operations.db_input(db_operations.get_user_data()))
            print()

            
        elif user_choice == "q":
            print(CONST.QUIT_MESSAGE)
            exit()
            
            