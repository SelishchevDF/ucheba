# Создайте словарь со списком вещей для похода в качестве ключа и их массой в качестве значения. 
# Определите какие вещи влезут в рюкзак передав его максимальную грузоподъёмность.
# Достаточно вернуть один допустимый вариант. *Верните все возможные варианты комплектации рюкзака.

tools = {"меч": 2, "топор": 3, "котелок": 4, "удочка": 5, "консерва": 6, "вилка": 1}
weight_limit = 10
temp_keys = []
temp_values = []
result = []
tools_keys = list(tools.keys())
tools_values = list(tools.values())

print(tools_keys)
print(tools_values)

for i in range(len(tools_keys)):
    if tools_values[i] <= weight_limit:
        temp_keys = []
        temp_values = []
        for j in range(i, len(tools_keys)):
            if sum(temp_values) + tools_values[j] <= weight_limit:
                temp_values.append(tools_values[j])
                temp_keys.append(tools_keys[j])
                print(temp_keys)
