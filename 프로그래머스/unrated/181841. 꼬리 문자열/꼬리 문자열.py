def solution(str_list, ex):
    answer = ''
    for x in str_list:
        if ex not in x:
            answer += x
    return answer