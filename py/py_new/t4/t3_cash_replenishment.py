from t3_const import *
 

def checking_multiplicity(how_much_to_replenishment: int):
    if int(how_much_to_replenishment) % int(MULTIPLICTY_WITHDRAWAL) == 0:
        return True
    else: return False

def replenishment(how_much_to_replenishment:int, amount_of_money:float, operation_count:int):
    if checking_multiplicity(how_much_to_replenishment):
        operation_count += 1
        amount_of_money_temp = amount_of_money + how_much_to_replenishment
        
        return amount_of_money_temp, operation_count, REPLENISHMENT_SUCCESS
    else: return amount_of_money, operation_count, ERROR_MULTIPLICTY_REPLENISHMENT