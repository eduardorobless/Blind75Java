from itertools import combinations

# Define the numbers
#numbers = [3, 4, -1, 0, 6, 2, 3]
#numbers = [7,7,7,7,7,7,7]
#numbers = [0,1,0,3,2,3]
def main(numbers): 
   
    if numbers is not None and len(numbers) > 0: 

        if not validate_input_type(numbers): 
            raise ValueError("Array can only contain integer values")
        
        longest = longest_increasing_subsequence(numbers)
        print('The longest increasing subsequence has a legth of {}'.format(longest))



    else: 
        raise ValueError("Give a non empty integer array")

def validate_input_type(numbers):
    return all(isinstance(number, int) for number in numbers)


def get_combinations(numbers): 
    all_combinations = []

    for r in range(len(numbers) + 1):
        all_combinations.extend(combinations(numbers, r))

    for combination in all_combinations:
        print(combination)
    return all_combinations

def longest_increasing_subsequence(numbers):


    all_combinations = get_combinations(numbers)
    # Generate all combinations
    max_length = 0    
    last_digit = None
    for comb in all_combinations: 
        length = 0
        for idx, number in enumerate(comb):
            if idx == 0:
                last_digit = number
                length += 1
            else: 
                if number <= last_digit:       
                    break
                else: 
                    length+= 1
                    last_digit = number

        max_length = max(length, max_length)
            
    return max_length
        
# Print all combinations


if __name__ == "__main__":
    numbers = [0,1,0,3,2,3]
    main(numbers)