def solution(a, b, c, d):
    answer = 0
    lst_abcd = [a, b, c, d]
    set_abcd = set(lst_abcd)

    if len(set_abcd) == 4:
        return min(a, b, c, d)
    elif len(set_abcd) == 3:
        sub = []
        for i in set_abcd:
            if lst_abcd.count(i) == 1:
                sub.append(i)
        return sub[0] * sub[1]
    elif len(set_abcd) == 2:
        sub = [lst_abcd.count(x) for x in set_abcd]
        if 2 in sub:
            m = max(lst_abcd)
            n = min(lst_abcd)
            return (m + n) * abs(m - n)
        else:
            p = 0
            q = 0
            for x in set_abcd:
                if lst_abcd.count(x) == 3:
                    p = x
                elif lst_abcd.count(x) == 1:
                    q = x
            return (10 * p + q) ** 2
    elif len(set_abcd) == 1:
        return lst_abcd[0] * 1111

