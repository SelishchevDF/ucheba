from datetime import datetime as dt

def apk_log(strin_for_lof,data_for_log):
    path = 'logging.csv'
    time_sign = dt.now().strftime('%D %H:%M')
    f = open(path, 'a', encoding="utf-8")
    f.write(f'{time_sign}--> {strin_for_lof} - {data_for_log}\n')
    f.close()