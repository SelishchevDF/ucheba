def isint(s):
    """проверка преобразования в число"""
    try:
        int(s)
        return True
    except ValueError:
        return False
