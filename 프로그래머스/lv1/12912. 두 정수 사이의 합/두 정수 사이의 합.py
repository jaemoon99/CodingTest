def solution(a, b):
    a_to_b = [x for x in range(min(a,b), max(a,b)+1)]
    return sum(a_to_b)