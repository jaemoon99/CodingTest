def solution(my_strings, parts):
    answer = ''
    for x in range(len(my_strings)):
        answer += my_strings[x][parts[x][0]:parts[x][1] + 1]
    return answer