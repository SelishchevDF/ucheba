import unittest
import pytest


def say_something(message: str, how_many: int =1, delimiter:str =' '):
    '''
    say_something returns a string in which message is repeated how_many times, separated by delimiter
    
    >>> say_something('hello world', 2)
    'hello world hello world'
    >>> say_something('hello world')
    'hello world'
    >>> say_something('hello world', 2,'*')
    'hello world*hello world'
    '''
    res = ""
    for i in range(how_many):
        res += message + delimiter
    return res[0:len(res)-len(delimiter)]

class TestCaseNumbers(unittest.TestCase):
    def test_1(self):
        self.assertEqual(say_something('hello world', 2), 'hello world hello world')

    def test_2(self):
        self.assertEqual(say_something('hello world'), 'hello world')

    def test_3(self):
        self.assertEqual(say_something('hello world', 2,'*'), 'hello world*hello world')

def test_1():
    assert say_something('hello world', 2) == 'hello world hello world'

def test_2():
    assert say_something('hello world') == 'hello world'

def test_3():
    assert say_something('hello world', 2,'*') == 'hello world*hello world'

if __name__ == '__main__':
    import doctest

    doctest.testmod(verbose=True)
    unittest.main(verbosity=2)
    pytest.main()
        
