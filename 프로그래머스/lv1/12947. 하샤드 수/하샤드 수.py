def solution(x):
    str_x = str(x)
    x_list = [int(y) for y in str_x]
    x_sum = sum(x_list)
    if x % x_sum == 0:
        return True
    else:
        return False