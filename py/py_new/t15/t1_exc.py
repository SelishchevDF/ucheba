class UserException(Exception):
    pass


class UserValueError(UserException):
    def __init__(self, value):
        self.value = value

    def __str__(self):
        return f'значение пользователя {self.value} не подходит условиям'