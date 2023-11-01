def solution(arr):
    answer = 0
    before_arr = arr
    while 1:
        after_arr = []
        for x in before_arr:
            if x >= 50 and x % 2 == 0:
                after_arr.append(x // 2)
            elif 50 > x and x % 2 == 1:
                after_arr.append(x * 2 + 1)
            else:
                after_arr.append(x)
        if before_arr == after_arr:
            return answer
        else:
            before_arr = after_arr
            answer += 1
            