# Напишите функцию принимающую на вход только ключевые параметры и возвращающую словарь,
# где ключ - значение переданного аргумента, а значение - имя аргумента.
# Если ключ не хешируем, используйте его строковое представление.

def do_dictionary(**kwargs):
    result = {}
    for key, value in kwargs.items():
        try:
            t_key = hash(value)
        except:
            t_key = str(value)
        t_value = key
        result[t_key] = t_value 
    return result


print(do_dictionary(name='первый', age=123, has_work=True,))
