import random


def bogosort(input_data):
    if len(input_data) <= 1:
        return input_data
    while not_sorted(input_data):
        shuffle_randomly(input_data)
    return input_data


def not_sorted(input_data):
    for i in range(0, len(input_data) - 1):
        if input_data[i] > input_data[i + 1]:
            return True
    return False


def shuffle_randomly(input_data):
    for i in range(0, len(input_data) - 1):
        r = random.randint(0, len(input_data) - 1)
        input_data[i], input_data[r] = input_data[r], input_data[i]
