import unittest

from parallel_bogosort import parallel_bogosort


class MyTestCase(unittest.TestCase):

    def test_returns_self(self):
        self.assertEqual(parallel_bogosort([1], 1), [1])
        self.assertEqual(parallel_bogosort([], 1), [])

    def test_sort(self):
        """Parallel bogosort algorithm version can complete 9 times more work in a comparable amount of time
            then a regular version
        """
        self.assertEqual(parallel_bogosort([1, 0, 2, 6, 7, 5, 3, 4, 8], 8), [0, 1, 2, 3, 4, 5, 6, 7, 8])


if __name__ == '__main__':
    unittest.main()
