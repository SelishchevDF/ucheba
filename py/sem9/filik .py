
from telegram import Update, Bot
from telegram.ext import Updater, CommandHandler, Filters, MessageHandler, ConversationHandler
from config import TOKEN
from mylogger import apk_log
import check
import random

bot = Bot(token=TOKEN)
updater = Updater(token=TOKEN)
dispatcher = updater.dispatcher

global num
num = 0
global user
user = 0
global num_at_tern
num_at_tern = 0
global bot_name
bot_name = 0
global num1
num1 = 0
global num2
num2 = 0

GAME, NUM, NUM_AT_TERN, DRAW, USER_TERN, BOT_TERN, NUM1, NUM2, ZNAK, CALC = range(10)


def menu(update, context):
    context.bot.send_message(update.effective_chat.id, 'играем(1) или считаем(2)?')
    text = update.message.text
    if text == '1':
        context.bot.send_message(update.effective_chat.id, 'играем, напиши ченить')
        apk_log('пользователь выбрал', "играть")
        return GAME
    elif text == '2':
        context.bot.send_message(update.effective_chat.id, 'считаем напиши ченить')
        apk_log('пользователь выбрал', "считать")
        return CALC

def game(update, context):
    # запомнили имя игрока
    global user
    user = update.message.from_user
    user = user.first_name
    context.bot.send_message(update.effective_chat.id, f"Привет, {user}, сколько конфет будет?")
    return NUM

def num_konf(update, context):
    # выбрали сколько конфет
    global num
    num = update.message.text
    if (check.isint(num) and 1 < int(num)):
        apk_log('пользователь задал', f'{num} конфет')
        print(f'конфет всего {num}')
        context.bot.send_message(update.effective_chat.id, "Сколько конфет можно брать за ход?")
        return NUM_AT_TERN
    else:
        context.bot.send_message(update.effective_chat.id, "конфет должно быть больше одной")

def num_konf_at_tern(update, context):
    # выбрали сколько конфет за ход
    global num
    global num_at_tern
    num_at_tern = update.message.text
    context.bot.send_message(update.effective_chat.id, num)
    if (check.isint(num_at_tern) and 0 < int(num_at_tern) and int(num_at_tern) < int(num)):
        apk_log('пользователь задал', f'{num_at_tern} конфет за ход')
        print(f'конфет за ход {num_at_tern}')
        context.bot.send_message(update.effective_chat.id, "напиши для жеребьевки")
        return DRAW
    else:
        context.bot.send_message(update.effective_chat.id, "конфет должно быть больше 0, но меньше общего количества")

def draw(update, context):
    global bot_name
    global user
    bot_name = "БОТЯРА"
    if random.randint(1,2) == 1:
        first_player = user
        bot = bot_name
        print("первый игрок")
        context.bot.send_message(update.effective_chat.id, (f'первый ходит {first_player}, второй ходит {bot}'))
        return USER_TERN
    else:
        first_player = bot_name
        bot = user
        print('первый ботяра')
        context.bot.send_message(update.effective_chat.id, (f'первый ходит {first_player}, второй ходит {bot}'))
        context.bot.send_message(update.effective_chat.id, ('для хода бота ченить напиши'))
        return BOT_TERN

def user_tern(update, context):
    global num
    global num_at_tern
    global user
    context.bot.send_message(update.effective_chat.id, ('для хода бота ченить напиши'))
    print(f'ходжит игрок конфет осталось {num}')
    num_temp = update.message.text
    if (check.isint(num_temp) and 0 < int(num_temp) <= int(num_at_tern)) :
        apk_log('пользователь взял', f'{num_temp} конфет')
        num = int(num) - int(num_temp)
        print(f'ходил игрок конфет {num}')
        if int(num) > 0:
            return BOT_TERN
        else:
            context.bot.send_message(update.effective_chat.id, (f'победил  ~{user}'))
            return ConversationHandler.END

def bot_tern(update, context):
    global num
    global num_at_tern
    if int(num) < (int(num_at_tern)+1):
        bot_take = int(num)-1   
    else:
        bot_take = random.randint(1,int(num_at_tern))
    context.bot.send_message(update.effective_chat.id, (f'БОТЯРА взял {bot_take}'))
    print(f'БОТЯРА взял {bot_take}')
    num = int(num) - bot_take
    print(f'ходил бот конфет {num}')
    if (int(num)) > 0:
        context.bot.send_message(update.effective_chat.id, (f'конфет осталось {num}, сколько взять?'))
        return USER_TERN
    else:
        context.bot.send_message(update.effective_chat.id, (f'победил  ~БОТЯРА'))
        return ConversationHandler.END

def calc(update, context):
    context.bot.send_message(update.effective_chat.id, 'Введи 1е число(комплексное в формате 10+11j)')
    return NUM1

def num1(update, context):
    global num1
    num1 = update.message.text
    if check.ischislo(num1):
        apk_log("первое число от пользователя", num1)
        context.bot.send_message(update.effective_chat.id, 'Введи 2е число(комплексное в формате 10+11j)')
        return NUM2

def num2(update, context):
    global num2
    num2 = update.message.text
    if check.ischislo(num2):
        apk_log("второе число от пользователя", num2)
        context.bot.send_message(update.effective_chat.id, 'выбери знак + - * /')
        return ZNAK

def znak(update, context):
    global num2
    global num1
    znak1 = update.message.text
    apk_log("знак от пользователя", znak1)
    if znak1 == "+":
        otvet = int(num1) + int(num2)
        context.bot.send_message(update.effective_chat.id, f'результат{num1} {znak1} {num2} = {otvet}')
        return ConversationHandler.END
    elif znak1 == "-":
        otvet = int(num1) - int(num2)
        context.bot.send_message(update.effective_chat.id, f'результат{num1} {znak1} {num2} = {otvet}')
        return ConversationHandler.END
    if znak1 == "*":
        otvet = int(num1) * int(num2)
        context.bot.send_message(update.effective_chat.id, f'результат{num1} {znak1} {num2} = {otvet}')
        return ConversationHandler.END
    if znak1 == "/":
        otvet = int(num1) / int(num2)
        context.bot.send_message(update.effective_chat.id, f'результат{num1} {znak1} {num2} = {otvet}')
        return ConversationHandler.END

def cancel(update, _):
    # определяем пользователя
    user = update.message.from_user
    # Пишем в журнал о том, что пользователь не разговорчивый
    # Отвечаем на отказ поговорить
    update.message.reply_text(
        'Мое дело предложить - Ваше отказаться'
    )
    # Заканчиваем разговор.
    return ConversationHandler.END

# Определяем обработчик разговоров `ConversationHandler` 
conv_handler = ConversationHandler( # здесь строится логика разговора
    # точка входа в разговор
    entry_points=[MessageHandler(Filters.text, menu)],
    # этапы разговора, каждый со своим списком обработчиков сообщений
    states={
        GAME: [MessageHandler(Filters.text, game)],
        NUM: [MessageHandler(Filters.text, num_konf)],
        NUM_AT_TERN: [MessageHandler(Filters.text, num_konf_at_tern)],
        DRAW: [MessageHandler(Filters.text, draw)],
        USER_TERN: [MessageHandler(Filters.text, user_tern)],
        BOT_TERN: [MessageHandler(Filters.text, bot_tern)],
        NUM1: [MessageHandler(Filters.text, num1)],
        NUM2: [MessageHandler(Filters.text, num2)],
        ZNAK: [MessageHandler(Filters.text, znak)],
        CALC: [MessageHandler(Filters.text, calc)],
    },
    # точка выхода из разговора
    fallbacks=[CommandHandler('cancel', cancel)],
)

    # Добавляем обработчик разговоров `conv_handler`
dispatcher.add_handler(conv_handler)    

print('server started')
updater.start_polling()
updater.idle()




