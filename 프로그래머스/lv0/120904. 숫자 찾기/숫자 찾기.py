def solution(num, k):
    count = 0
    print(str(num))
    for x in str(num):
        if x == str(k):
            return count+1
        else:
            count+=1
    return -1