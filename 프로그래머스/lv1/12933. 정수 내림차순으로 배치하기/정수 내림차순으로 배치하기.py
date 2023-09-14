def solution(n):
    answer = ''
    n_list = [int(x) for x in str(n)]
    while 1:
        for x in n_list:
            if x == max(n_list):
                answer += str(x)
                n_list.remove(x)
                break
        if len(n_list) == 0:
            return int(answer)
        