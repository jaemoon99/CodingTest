def solution(array, height):
    cnt = 0
    for x in array:
        if x > height:
            cnt += 1
    return cnt