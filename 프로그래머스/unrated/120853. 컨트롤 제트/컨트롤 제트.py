def solution(s):
    answer = 0
    split_list = list(s.split(' '))
    for x in range(len(split_list)):
        if split_list[x] == "Z":
            answer -= int(split_list[x - 1])
        else:
            answer += int(split_list[x])
    return answer