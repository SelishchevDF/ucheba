def isint(s):
    """проверка преобразования в число"""
    try:
        int(s)
        return True
    except ValueError:
        return False

def ischislo(s):
    """проверка преобразования в число"""
    try:
        float(s)
        return True
    except ValueError:
        try:
            complex(s)
            return True
        except ValueError:
            return False

        
    except ValueError:
        return False