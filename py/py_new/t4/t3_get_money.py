from t3_wealth_tax import wealth_tax_check
from t3_logger import write_to_logfile
from t3_const import *
from t3_cash_withdrawal import withdraw
from t3_oreration_count import operations_count

def get_money(how_much_to_withdraw:int, amount_of_money:float, operation_count:int):
    
    write_to_logfile(LOGFILE_PATH, amount_of_money, WEALTH_TAX_START_INFO)
    amount_of_money, temp_str = wealth_tax_check(amount_of_money)
    write_to_logfile(LOGFILE_PATH, amount_of_money, temp_str)
    
    write_to_logfile(LOGFILE_PATH, amount_of_money, WITHDRAWAL_START)
    amount_of_money, operation_count, temp_str = withdraw(how_much_to_withdraw, amount_of_money, operation_count)
    write_to_logfile(LOGFILE_PATH, amount_of_money, temp_str)
    
    if temp_str != ERROR_MULTIPLICTY_WITHDRAWAL:
        write_to_logfile(LOGFILE_PATH, amount_of_money, OPERATION_COUNT_START)
        operation_count, amount_of_money, temp_str = operations_count(operation_count, amount_of_money)
        write_to_logfile(LOGFILE_PATH, amount_of_money, temp_str)
    
    return amount_of_money, operation_count
    
    