def solution(myString, pat):
    split_list = myString.split(pat)
    if '' in split_list:
        if split_list[-1] != '':
            split_list = split_list[:-1]
        for x in range(len(split_list)):
            if split_list[x] == "":
                split_list[x] = pat
        return ''.join(split_list)

    else:
        answer = ''
        for x in split_list[:-1]:
            answer += x+pat
        return answer