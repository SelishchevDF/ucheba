from t3_const import *

def checking_multiplicity(how_much_to_withdraw:int):
    if how_much_to_withdraw % MULTIPLICTY_WITHDRAWAL == 0:
        return True
    else: return False
    
def commission_calculation (how_much_to_withdraw:int):
    res = how_much_to_withdraw * PERCENTAGE_FOR_WITHDRAWAL
    if res <= PERCENTAGE_FOR_WITHDRAWAL_MIN:
        res = PERCENTAGE_FOR_WITHDRAWAL_MIN
        return res
    elif res >= PERCENTAGE_FOR_WITHDRAWAL_MAX:
        res = PERCENTAGE_FOR_WITHDRAWAL_MAX
        return res
    else: return res
    
def withdraw(how_much_to_withdraw:int, amount_of_money:float, operation_count:int):
    if checking_multiplicity(how_much_to_withdraw):
        amount_of_money_temp = amount_of_money - how_much_to_withdraw - commission_calculation(how_much_to_withdraw)
        if amount_of_money_temp >= 0:
            operation_count += 1
            return amount_of_money_temp, operation_count, WITHDRAWAL_SUCCESS
        else: amount_of_money, operation_count, ERROR_WITHDRAWAL
    return amount_of_money, operation_count, ERROR_MULTIPLICTY_WITHDRAWAL
    
        
    
    