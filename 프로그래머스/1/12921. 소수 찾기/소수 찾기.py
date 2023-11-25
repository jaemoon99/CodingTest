def solution(n):
    prime_nums = set([x for x in range(2, n+1)])
    
    for i in range(2, int(n ** 0.5) + 1):
        if i in prime_nums:
            prime_nums -= set(x for x in range(i*2, n+1, i))
        
    count = len(prime_nums)
            
    return count