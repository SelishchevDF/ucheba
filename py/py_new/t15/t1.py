import sys
from t1_exc import UserValueError
from t1_log import MyLogger

def is_simple(value:int):
    k = 0
    for i in range(2, (value // 2)+1):
        if (value % i == 0):
            k = k+1
    if (k <= 0):
        return True
    else:
        return False
    
def programm(value: str):
    logger = MyLogger()
    logger.write_start(value)
    try:
        v = int(value)
        if v <= 1000 and v >= 2:
            res = is_simple(v)
            logger.write_stop(res)
            return res
        else:
            raise UserValueError(v)
    except UserValueError as e:
        logger.write_error(e)
    except Exception as e:
        logger.write_error(e)
        
if __name__ == '__main__':
    programm(sys.argv[1])