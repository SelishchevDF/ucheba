# 5- Найти произведение пар чисел в списке. Парой считаем первый и последний элемент, второй и предпоследний и т.д.

import math

list_num = [2, 3, 4, 5, 6, 7, 8]

prod_list = lambda x: [x[i] * x[-i-1] for i in range(math.ceil(len(x)/2))]
print(list(prod_list(list_num)))