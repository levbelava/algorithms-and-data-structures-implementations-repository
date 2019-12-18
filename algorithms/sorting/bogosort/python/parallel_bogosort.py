import multiprocessing
import random
import copy
from multiprocessing import Value


def parallel_bogosort(input_data, number_of_processes_to_spawn):
    if len(input_data) <= 1:
        return input_data
    result_queue = multiprocessing.Manager().Queue()
    sorting_jobs = create_sorting_jobs(input_data, number_of_processes_to_spawn, result_queue)
    start_jobs(sorting_jobs)
    wait_until_completed(sorting_jobs)
    return result_queue.get()


def create_sorting_jobs(input_data, number_of_processes_to_spawn, result_queue):
    shared_completion_flag = Value('i', 0)
    sorting_jobs = []
    for i in range(0, number_of_processes_to_spawn):
        sorting_job = multiprocessing.Process(target=bogosort_worker,
                                          args=(input_data, shared_completion_flag, result_queue))
        sorting_jobs.append(sorting_job)
    return sorting_jobs


def start_jobs(jobs):
    for j in jobs:
        j.start()


def wait_until_completed(jobs):
    for j in jobs:
        j.join()


def bogosort_worker(input_data, shared_completion_flag, result_queue):
    copy_of_input_data = copy.deepcopy(input_data)
    while is_not_sorted(copy_of_input_data):
        if shared_completion_flag.value == 1:
            return
        shuffle_randomly(copy_of_input_data)
    result_queue.put(copy_of_input_data)
    shared_completion_flag.value = 1


def is_not_sorted(input_data):
    for i in range(0, len(input_data) - 1):
        if input_data[i] > input_data[i + 1]:
            return True
    return False


def shuffle_randomly(input_data):
    for i in range(0, len(input_data) - 1):
        random_index = random.randint(0, len(input_data) - 1)
        input_data[i], input_data[random_index] = input_data[random_index], input_data[i]
