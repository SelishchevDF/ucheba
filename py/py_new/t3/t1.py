# Дан список повторяющихся элементов.
# Вернуть список с дублирующимися элементами. В результирующем списке не должно быть дубликатов.

list_of_numbers = [1,2,3,4,5,6,7,8,9,1,3,5,7,9,10,11,11]
temp_list: list = []

list_of_numbers.sort()
for i in range(len(list_of_numbers)):
    for j in range(i + 1, len(list_of_numbers)):
        if list_of_numbers[i] == list_of_numbers[j]:
            temp_list.append(list_of_numbers[i])
            break
        else: j += 1
    i += 1
        
print(temp_list)
