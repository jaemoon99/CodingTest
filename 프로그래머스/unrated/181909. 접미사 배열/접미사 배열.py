def solution(my_string):
    return sorted([my_string[x:] for x in range(0, len(my_string))])