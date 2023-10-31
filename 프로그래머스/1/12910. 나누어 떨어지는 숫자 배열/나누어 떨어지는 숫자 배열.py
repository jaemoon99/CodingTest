def solution(arr, divisor):
    if len(sorted([x for x in arr if x % divisor == 0]))== 0:
        return [-1]
    return sorted([x for x in arr if x % divisor == 0])