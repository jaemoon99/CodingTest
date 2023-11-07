def solution(l, r):
    answer = [x for x in range(l, r + 1) if str(x).replace("5", "").replace("0", "") == ""]
    if answer:
        return answer
    return [-1]