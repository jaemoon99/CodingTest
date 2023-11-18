def check(lst):
    if lst[1] - lst[0] == lst[2] - lst[1]:
        return lst[-1] + lst[1] - lst[0]
    else:
        return lst[-1] * (lst[1] // lst[0]) 
    
def solution(common):
    return check(common)