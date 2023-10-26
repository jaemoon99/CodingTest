def solution(num_list):
    answer = 0
    for x in num_list:
        while 1:
            if x == 1:
                break
            if x % 2 == 0:
                x = int(x / 2)
                answer += 1
            else:
                x = int((x - 1) / 2)
                answer += 1
    return answer