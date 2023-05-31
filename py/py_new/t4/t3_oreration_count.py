from t3_const import *
 
def operations_count(operation_count:int, amount_of_money:float):
    if operation_count >= OPERATION_COUNT_BEFORE_STACK:
        amount_of_money_temp = amount_of_money + OPERATION_COUNT_PERCENTAGE * amount_of_money
        operation_count = 0
        return operation_count, amount_of_money_temp, OPERATION_COUNT_REPLENISHMENT
    else: 
        temp_string = OPERATION_COUNT_REPLENISHMENT_INFO + str(OPERATION_COUNT_BEFORE_STACK - operation_count)
        return operation_count, amount_of_money, temp_string