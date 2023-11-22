def solution(strings, n):
    answer = []
    n_dict = dict()
    
    for x in strings:
        if n_dict.get(str(x[n])):
            n_dict[str(x[n])].append(x)
            n_dict[str(x[n])] = sorted(n_dict[str(x[n])])
        else:
            n_dict[str(x[n])] = [x]
    
    sorted_items = sorted(n_dict.items(), key=lambda x:x[0])
    
    for y in sorted_items:
        answer.append(y[1])
        
    return sum(answer, [])