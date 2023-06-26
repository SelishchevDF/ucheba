
class Matrix:
    """Класс для вывода на печать, сравнения и сложения матриц"""

    def __init__(self, matrix: list) -> None:
        """Создание экземпляра класса Matrix из списка списков"""
        self.matrix = matrix

    def show_matrix(self):
        """печать матрицы в консоль"""
        for i in self.matrix:
            print(i)
            print()
    
    def comparison(self, other) -> str:
        """Сравнение матриц"""
        result = ""
        if self.matrix < other.matrix: result = "Вторая матрица больше первой"
        elif self.matrix > other.matrix: result = "Первая матрица больше второй"
        else: result = "Матрицы равны"
        return result

    def __add__(self, other) :
        """Сложение матриц, возвращает экземпляр класса Matrix"""
        result = []
        nums = []
        for i in range(len(self.matrix)): 
            for j in range(len(self.matrix[i])):
                summa = self.matrix[i][j] + other.matrix[i][j]
                nums.append(summa)
                if len(nums) == len(self.matrix[i]):
                    result.append(nums)
                    nums = []
        return Matrix(result)
