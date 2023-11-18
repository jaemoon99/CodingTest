def check(lst):
    c = []
    for i in range(len(lst) - 1):
        c.append(lst[i + 1] - lst[i])
    
    if len(set(c)) == 1:
        return lst[-1] + c[0]
    else:
        return lst[-1] * (lst[1] // lst[0]) 
    
def solution(common):
    return check(common)