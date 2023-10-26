def solution(my_string, indices):
    answer = ''
    for x in range(len(my_string)):
        if x not in indices:
            answer += my_string[x]
    return answer