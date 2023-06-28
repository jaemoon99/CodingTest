from math import prod
def solution(num_list):
    if prod(num_list) < sum(num_list) ** 2:
        return 1
    return 0