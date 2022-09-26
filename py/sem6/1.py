# 1- Определить, присутствует ли в заданном списке строк, некоторое число

str_list = ["1234", "456", "789", "111", "222", "333"]
find_str = "111"

if len(list(filter(lambda x: find_str in x, str_list))) != 0: print("Входит")
else: print("не входит")