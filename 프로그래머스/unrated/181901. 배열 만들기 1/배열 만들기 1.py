def solution(n, k):
    return [x for x in range(k, n + 1) if x % k == 0]