def solution(num_list, n):
    answer = []
    for x in range(0, len(num_list), n):
        answer.append(num_list[x:x+n])
    return answer