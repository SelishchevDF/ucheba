
import datetime

def write_to_logfile(path, amount_of_money, information):
    temp_string = str(datetime.datetime.now()) + " " + str(amount_of_money) + " " +  information + "\n"
    with open(path, 'a', encoding="utf-8") as f:
        f.write(temp_string)