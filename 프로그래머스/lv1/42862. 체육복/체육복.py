def solution(n, lost, reserve):
    intersection = list(set(lost) & set(reserve))
    reserve = list(set(reserve) - set(intersection))
    lost = list(set(lost) - set(intersection))
    for x in reserve:
        if x - 1 in lost:
            lost.remove(x - 1)
        elif x + 1 in lost:
            lost.remove(x + 1)
    return n - len(lost)