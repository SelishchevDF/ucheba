import datetime
import CONST

def user_input(description=None): 
    return input(description)

def view_list(date:list):
    date.insert(0,CONST.HEADER)
    for line in date:
        print(line)
        
def now_time(): 
    return datetime.datetime.now().strftime("%Y-%m-%d %H:%M")

