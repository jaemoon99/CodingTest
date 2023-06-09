def solution(strArr):
    for x in range(len(strArr)):
        if (x % 2 == 0) or (x == 0):
            strArr[x] = strArr[x].lower()
        else:
            strArr[x] = strArr[x].upper()
    return strArr