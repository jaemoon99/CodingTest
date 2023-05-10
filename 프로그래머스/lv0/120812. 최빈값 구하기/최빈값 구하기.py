def solution(array):
    prev = 0
    answer = 1
    num = 0
    for x in set(array):
        if array.count(x) > prev:
            prev = array.count(x)
            answer = 1
            num = x
        elif array.count(x) == prev:
            answer += 1
    if answer > 1:
        return -1
    else:
        return num