def solution(left, right):
    answer = 0
    for x in range(left, right + 1):
        num_list = [y for y in range(1, x + 1) if x % y == 0]
        if len(num_list) % 2 == 1:
            answer -= x
        else:
            answer += x
    return answer