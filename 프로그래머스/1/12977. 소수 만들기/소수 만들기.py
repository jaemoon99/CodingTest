from itertools import combinations

def solution(nums):
    answer = 0
    nums = list(combinations(nums, 3))
    
    for x in nums:
        count = 0
        sub = sum(x)
        for y in range(1, sub + 1):
            if sub % y == 0:
                count += 1
        
        if count == 2:
            answer += 1
                
    return answer