def check_num(string_from_user):
    if (len(string_from_user) < 16) and ((string_from_user == "-") or (string_from_user[0] == '+' or (string_from_user[0] == '8'))):
        try:
            int(string_from_user[1::])
            return True
        except Exception:
            return False
    return False

        