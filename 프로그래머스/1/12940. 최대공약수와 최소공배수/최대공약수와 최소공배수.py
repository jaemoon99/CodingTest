def solution(n, m):
    min_num = min([x for x in range(m, n*m + 1) if (x % n == 0 and x % m == 0)])
    max_num = max([x for x in range(1, min(n, m) + 1) if n % x == 0 and m % x == 0])
            
    return [max_num, min_num]