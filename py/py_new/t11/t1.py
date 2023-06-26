from t1_matrix import Matrix

m1 = Matrix([[0, 1, 4, 2, 3],
       [4, 2, 0, 1, 5],
       [2, 2, 1, 0, 3],
       [3, 4, 5, 3, 0]])

m2 = Matrix([[0, 1, 2, 3, 4],
       [1, 5, 1, 1, 5],
       [2, 6, 2, 0, 3],
       [3, 7, 3, 3, 0]])

m3 = Matrix([[1, 1, 1, 1, 3],
       [2, 2, 2, 2, 5],
       [3, 3, 3, 3, 3],
       [4, 4, 4, 4, 0]])

print("показали матрицу")
m1.show_matrix()

print("сложили матрицу")
mplus = m2 + m3
mplus.show_matrix()

print("сравнили матрицу")
print(m1.comparison(mplus))