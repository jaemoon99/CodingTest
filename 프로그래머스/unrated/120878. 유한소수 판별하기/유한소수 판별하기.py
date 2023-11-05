def gcd(a, b):
    return max([x for x in range(1, min(a, b) + 1) if a % x == 0 and b % x == 0])
            

def factorization(num):
    i = 2
    res_list = []
    while num >= i:
        if num % i == 0:
            res_list.append(i)
            num //= i
        else:
            i += 1
            
    return res_list


def solution(a, b):
    answer = 0
    gcd_num = gcd(a, b)
    f_list = factorization(b//gcd_num)
    set_f = list(set(f_list))
    if len(set_f) == set_f.count(2) + set_f.count(5):
        return 1
    else:
        return 2