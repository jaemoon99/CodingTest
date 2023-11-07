def solution(numlist, n):
    answer = []
    while numlist:
        near = float("inf")
        if len(numlist) == 1:
            answer.append(numlist[0])
            break
        for i, num in enumerate(numlist):
            if abs(n - near) > abs(n - num):
                near = num
            elif abs(n - near) == abs(n - num):
                if num > near:
                    near = num
        numlist.remove(near)
        answer.append(near)
    return answer