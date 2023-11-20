def solution(sizes):
    answer = 0
    max_s = []
    min_s = []
    
    for x in sizes:
        i, j = x

        if i >= j:
            max_s.append(i)
            min_s.append(j)
        else:
            max_s.append(j)
            min_s.append(i)
    
    return max(max_s) * max(min_s)