from t3_const import *

def wealth_tax_check(amount_of_money:float):
    if amount_of_money > WEALTH_TAX_START:
        amount_of_money_temp = amount_of_money - WEALTH_TAX * amount_of_money
        return amount_of_money_temp, WEALTH_TAX_INFO
    else: return amount_of_money, WEALTH_TAX_INFO_NO_SUCH_MONEY