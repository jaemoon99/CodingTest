def solution(s):
    check_list = []
    for x in range(0, len(s)):
        if len(check_list) == 0:
            check_list.append(s[x])
        elif s[x] == check_list[-1]:
            check_list.pop()
        else:
            check_list.append(s[x])
    if len(check_list) == 0:
        return 1
    else:
        return 0