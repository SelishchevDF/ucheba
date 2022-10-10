
from telegram import Update, Bot
from telegram.ext import Updater, CommandHandler, Filters, MessageHandler, ConversationHandler
from config import TOKEN
from mylogger import apk_log
import check
import operations
import importdb
import exportdb

bot = Bot(token=TOKEN)
updater = Updater(token=TOKEN)
dispatcher = updater.dispatcher

MENU, NAME, SECNAME, TEL,TEL2, DESCRIPTION_PROFILE, DELL_PROFILE, EDIT_PROFILE, FIND_PROFILES = range(9)

global edit_flag
edit_flag = 0

def hello_user(update, context):
    text = update.message.text
    context.bot.send_message(update.effective_chat.id, 'Привет! /start что бы начать')
    apk_log('пользователь написал', text)

def start_dic(update, context):
    context.args
    context.bot.send_message(update.effective_chat.id, 'Привет! \n'
                                                        '1 - добавить профиль \n'
                                                        '2 - посмотреть содержимое \n'
                                                        '3 - удалить профиль \n'
                                                        '4 - импорт профилей \n'
                                                        '5 - экспорт профилей \n'
                                                        '6 - поиск \n'
                                                        '7 - редактировать профиль \n'
                                                        '/cancel - выйти')
    apk_log('пользователь начал диалог',"")
    return MENU

def menu(update, context):
    text = update.message.text

    if text == '1':
        context.bot.send_message(update.effective_chat.id, 'введите имя нового контакта')
        apk_log('пользователь выбрал ', "добавить новый контакт")
        return NAME

    elif text == '2':
        apk_log('пользователь выбрал', "посмотреть все контакты")
        context.bot.send_message(update.effective_chat.id, f'контакты в безе\n{operations.db_view()} ')
        context.bot.send_message(update.effective_chat.id, 'Возвращаемся в меню \n'
                                                        '1 - добавить профиль \n'
                                                        '2 - посмотреть содержимое \n'
                                                        '3 - удалить профиль \n'
                                                        '4 - импорт профилей \n'
                                                        '5 - экспорт профилей \n'
                                                        '6 - поиск \n'
                                                        '7 - редактировать профиль \n'
                                                        '/cancel - выйти')
        return MENU

    elif text == '3':
        context.bot.send_message(update.effective_chat.id, f'контакты в безе \n {operations.db_view()} ')
        context.bot.send_message(update.effective_chat.id, 'выберите id профиля, который нужно удалить')
        apk_log('пользователь выбрал', "удаление профиля")
        return DELL_PROFILE

    elif text == '4':
        apk_log('пользователь выбрал', "импорт")
        try:
            importdb.db_import("dbimport.json","db.csv")
            context.bot.send_message(update.effective_chat.id, 'Импорт выполнен. Возвращаемся в меню \n'
                                                        '1 - добавить профиль \n'
                                                        '2 - посмотреть содержимое \n'
                                                        '3 - удалить профиль \n'
                                                        '4 - импорт профилей \n'
                                                        '5 - экспорт профилей \n'
                                                        '6 - поиск \n'
                                                        '7 - редактировать профиль \n'
                                                        '/cancel - выйти')
        except Exception:
            context.bot.send_message(update.effective_chat.id, 'Импорт НЕ выполнен. Возвращаемся в меню \n'
                                                        '1 - добавить профиль \n'
                                                        '2 - посмотреть содержимое \n'
                                                        '3 - удалить профиль \n'
                                                        '4 - импорт профилей \n'
                                                        '5 - экспорт профилей \n'
                                                        '6 - поиск \n'
                                                        '7 - редактировать профиль \n'
                                                        '/cancel - выйти')

        return MENU

    elif text == '5':
        apk_log('пользователь выбрал', "экспорт")
        exportdb.db_export("db.csv","db.json")
        context.bot.send_message(update.effective_chat.id, 'Экспорт выполнен. Возвращаемся в меню \n'
                                                        '1 - добавить профиль \n'
                                                        '2 - посмотреть содержимое \n'
                                                        '3 - удалить профиль \n'
                                                        '4 - импорт профилей \n'
                                                        '5 - экспорт профилей \n'
                                                        '6 - поиск \n'
                                                        '7 - редактировать профиль \n'
                                                        '/cancel - выйти')
        return MENU

    elif text == '6':
        context.bot.send_message(update.effective_chat.id, 'введите искомое слово')
        apk_log('пользователь выбрал', "поиск")
        return FIND_PROFILES
    
    elif text == '7':
        context.bot.send_message(update.effective_chat.id, f'контакты в безе \n {operations.db_view()} ')
        context.bot.send_message(update.effective_chat.id, 'выберите id профиля, который нужно редактировать')
        apk_log('пользователь выбрал', "редактирование профиля")
        return EDIT_PROFILE

    else: 
        context.bot.send_message(update.effective_chat.id, 'повторите ввод корректно \n'
                                                        '1 - добавить профиль \n'
                                                        '2 - посмотреть содержимое \n'
                                                        '3 - удалить профиль \n'
                                                        '4 - импорт профилей \n'
                                                        '5 - экспорт профилей \n'
                                                        '6 - поиск \n'
                                                        '7 - редактировать профиль \n'
                                                        '/cancel - выйти')
        return MENU        

def cancel(update, context):
    context.bot.send_message(
            update.effective_chat.id, f'Операция прервана')
    return ConversationHandler.END

def name(update, context):
    text = update.message.text
    apk_log('пользователь написал', text)
    global temp_user_list
    temp_user_list = list()
    temp_user_list.append(text)
    context.bot.send_message(update.effective_chat.id, 'введите фамилию контакта ')
    return SECNAME

def secname(update, context):
    text = update.message.text
    apk_log('пользователь написал', text)
    temp_user_list.append(text)
    context.bot.send_message(update.effective_chat.id, 'введите телефон контакта с + или 8 ')
    return TEL

def tel(update, context):
    text = update.message.text
    if check.check_num(text):
        apk_log('пользователь написал', text)
        temp_user_list.append(text)
        context.bot.send_message(update.effective_chat.id, 'введите добавочный телефон контакта с + или 8')
        return TEL2
    else:
        apk_log('пользователь не прошел проверку телефона', text)
        context.bot.send_message(update.effective_chat.id, 'введите правильно телефон контакта с + или 8 ')
        return TEL

def tel2(update, context):
    text = update.message.text
    if check.check_num(text):
        apk_log('пользователь написал', text)
        temp_user_list.append(text)
        context.bot.send_message(update.effective_chat.id, 'введите описание профиля')
        return DESCRIPTION_PROFILE
    else:
        apk_log('пользователь не прошел проверку телефона', text)
        context.bot.send_message(update.effective_chat.id, 'введите правильно телефон контакта с + или 8 ')
        return TEL2

def description_profile(update, context):
    text = update.message.text
    apk_log('пользователь написал', text)
    temp_user_list.append(text)
    global edit_flag
    if edit_flag != 0:
        operations.db_edit(edit_flag,temp_user_list)
        temp_user_list.clear()
        context.bot.send_message(update.effective_chat.id, f'вы отредактировали контакт')
        context.bot.send_message(update.effective_chat.id, 'Возвращаемся в меню \n'
                                                        '1 - добавить профиль \n'
                                                        '2 - посмотреть содержимое \n'
                                                        '3 - удалить профиль \n'
                                                        '4 - импорт профилей \n'
                                                        '5 - экспорт профилей \n'
                                                        '6 - поиск \n'
                                                        '7 - редактировать профиль \n'
                                                        '/cancel - выйти')
        edit_flag = 0
    else:
        operations.db_input(temp_user_list)
        context.bot.send_message(update.effective_chat.id, f'вы добавили контакт {temp_user_list} ')
        temp_user_list.clear()
        context.bot.send_message(update.effective_chat.id, 'Возвращаемся в меню \n'
                                                        '1 - добавить профиль \n'
                                                        '2 - посмотреть содержимое \n'
                                                        '3 - удалить профиль \n '
                                                        '4 - импорт профилей \n'
                                                        '5 - экспорт профилей \n'
                                                        '6 - поиск \n'
                                                        '7 - редактировать профиль \n'
                                                        '/cancel - выйти')
    return MENU

def dell_profile(update, context):
    text = update.message.text
    apk_log('пользователь удалил', text)
    operations.db_item_del(text)
    context.bot.send_message(update.effective_chat.id, 'Контакт удален. Возвращаемся в меню \n'
                                                        '1 - добавить профиль \n'
                                                        '2 - посмотреть содержимое \n'
                                                        '3 - удалить профиль \n'
                                                        '4 - импорт профилей \n'
                                                        '5 - экспорт профилей \n'
                                                        '6 - поиск \n'
                                                        '7 - редактировать профиль \n'
                                                        '/cancel - выйти')
    return MENU

def edit_profile(update, context):
    global edit_flag
    edit_flag = 0
    edit_flag = update.message.text
    apk_log('пользователь редактирует id', edit_flag)
    context.bot.send_message(update.effective_chat.id, 'введите имя контакта')
    return NAME

def find_profiles(update, context):
    text = update.message.text
    apk_log('пользователь искал', text)
    context.bot.send_message(update.effective_chat.id, f'найденные контакты в базе \n {operations.db_search(text)} ')
    context.bot.send_message(update.effective_chat.id, 'Возвращаемся в меню \n'
                                                        '1 - добавить профиль \n'
                                                        '2 - посмотреть содержимое \n'
                                                        '3 - удалить профиль \n'
                                                        '4 - импорт профилей \n'
                                                        '5 - экспорт профилей \n'
                                                        '6 - поиск \n'
                                                        '7 - редактировать профиль \n'
                                                        '/cancel - выйти')
    return MENU

# Определяем обработчик разговоров `ConversationHandler` 
conv_handler = ConversationHandler( # здесь строится логика разговора
    # точка входа в разговор
    entry_points=[CommandHandler('start', start_dic)],
    # этапы разговора, каждый со своим списком обработчиков сообщений
    states={
        MENU: [MessageHandler(Filters.text, menu)],
        NAME: [MessageHandler(Filters.text, name)],
        SECNAME: [MessageHandler(Filters.text, secname)],
        TEL: [MessageHandler(Filters.text, tel)],
        TEL2: [MessageHandler(Filters.text, tel2)],
        DESCRIPTION_PROFILE: [MessageHandler(Filters.text, description_profile)],
        DELL_PROFILE: [MessageHandler(Filters.text, dell_profile)],
        EDIT_PROFILE: [MessageHandler(Filters.text, edit_profile)],
        FIND_PROFILES: [MessageHandler(Filters.text, find_profiles)],
    },
    # точка выхода из разговора
    fallbacks=[CommandHandler('cancel', cancel)],
)

message_handler = MessageHandler(Filters.text, hello_user)

dispatcher.add_handler(conv_handler)
dispatcher.add_handler(message_handler)

print('server started')
updater.start_polling()
updater.idle()
