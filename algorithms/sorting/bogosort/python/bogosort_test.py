import unittest

from bogosort import bogosort


class MyTestCase(unittest.TestCase):

    def test_returns_self(self):
        self.assertEqual(bogosort([1]), [1])
        self.assertEqual(bogosort([]), [])

    def test_sort(self):
        """Python is a lot slower then Java so it can't sort array of 10 elements in a reasonable time
            should use 9 or less elements instead
        """
        self.assertEqual(bogosort([1, 0, 2, 6, 7, 5, 3, 4]), [0, 1, 2, 3, 4, 5, 6, 7])


if __name__ == '__main__':
    unittest.main()
