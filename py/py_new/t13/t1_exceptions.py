class UserException(Exception):
    pass


class UserTypeError(UserException):
    def __init__(self, value):
        self.value = value

    def __str__(self):
        return f'треугольник {self.value} не существует'