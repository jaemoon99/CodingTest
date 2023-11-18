def solution(lines):
    dot_dic = dict()
    for i, j in lines:
        for k in range(i, j):
            check = dot_dic.get((k, k + 1))
            if check == None:
                dot_dic[(k, k + 1)] = 1
            else:
                dot_dic[(k, k + 1)] += 1
    
    values = list(dot_dic.values())
    answer = [x for x in values if x != 1]
    
    return len(answer)