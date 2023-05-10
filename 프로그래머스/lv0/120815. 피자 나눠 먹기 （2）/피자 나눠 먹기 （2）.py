def solution(n):
    for x in range(max(n,6),n*6+1):
        if x%n == 0 and x%6 == 0:
            return x//6