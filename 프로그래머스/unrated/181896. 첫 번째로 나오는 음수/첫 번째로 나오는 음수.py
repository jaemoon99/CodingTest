def solution(num_list):
    for x in range(len(num_list)):
        if num_list[x] < 0:
            return x
    return -1