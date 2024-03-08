import unittest
from longest_increasing_subsequence import main, validate_input_type, longest_increasing_subsequence
from unittest.mock import patch



class TestMain(unittest.TestCase):
    def test_main_invalid_input_empty(self):
        with self.assertRaises(ValueError) as context:
            main(numbers= [])
        self.assertEqual(str(context.exception), 'Give a non empty integer array')
    
    def test_main_invalid_input_non_existing(self):
        with self.assertRaises(ValueError) as context: 
            main(numbers=None)
        self.assertEqual(str(context.exception), 'Give a non empty integer array')


    def test_main_valid_input_non_valid(self):
        with self.assertRaises(ValueError) as context:
            main(numbers=["234"])
        self.assertEqual(str(context.exception), 'Array can only contain integer values')

    def test_main_valid_input(self): 
        numbers = [7, 7, 7]
        with patch('longest_increasing_subsequence.longest_increasing_subsequence', return_value = 1) as mock_longest:
            with patch('builtins.print') as mock_print: 
                    main(numbers=numbers)
            mock_longest.assert_called_once_with(numbers)
            mock_print.assert_called_once_with('The longest increasing subsequence has a legth of 1')

class TestLongestIncreasingSubsequence(unittest.TestCase):
    def test_single_element(self):
        numbers = [7] 
        result = longest_increasing_subsequence(numbers)
        self.assertEqual(result, 1)            

    # def test_longest_input_subsequence(self):
    #     numbers = [0,1,0,3,2,3]
    #     with patch('longest_increasing_subsequence.longest_increasing_subsequence') as mock:
  
    
    # def test_main_invalid_input_non_integers(self):
    #     with self.assertRaises(ValueError) as context:
    #         with patch('longest_increasing_subsequence.validate_input_type', return_value=False):
    #             main()
    #     self.assertEqual(str(context.exception), 'Array can only contain int values')

    # @patch('builtins.print')
    # def test_main_valid_input(self, mock_print):
    #     numbers = [7, 7, 7]
    #     with patch('longest_increasing_subsequence.validate_input_type', return_value=True), \
    #          patch('longest_increasing_subsequence.longest_increasing_subsequece', return_value=1):
    #         main()
    #     mock_print.assert_called_once_with('The longest increasing subsequence has a length of 1')

if __name__ == '__main__':
    unittest.main()
