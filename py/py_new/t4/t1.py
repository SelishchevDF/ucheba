#Напишите функцию для транспонирования матрицы

m = [[1,2,3], [4,5,6], [7,8,9], [10,11,12]]

def t_m (m):
    m_t = [[m[j][i] for j in range(len(m))] for i in range(len(m[0]))]
    return m_t

print(m)
print(t_m(m))