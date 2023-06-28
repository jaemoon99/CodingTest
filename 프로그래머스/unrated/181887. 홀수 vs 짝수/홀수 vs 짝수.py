def solution(num_list):
    odd = 0
    even = 0
    for x in range(len(num_list)):
        if x % 2 == 0:
            even += num_list[x]
        else:
            odd += num_list[x]
    if even == odd:
        return even
    else:
        return max([odd, even])