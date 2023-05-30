def solution(nums):
    # 중복 제거
    nums_set = set(nums)
    
    # 중복 제거한 길이가 절반보다 같거나 크면
    if len(nums_set) < len(nums) // 2:
        
        # NUM 길이의 절반을 반환
        return len(nums_set)
    else:
        
        # 중복제거 길이만큼 반환
        return len(nums) // 2